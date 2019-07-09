package com.example.employeesapp;

//import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //Declaring variable for the database
    SQLiteDatabase db;
    //Declaring View Variables
    EditText editsearchname, editempname, editempmail, editempsalary;
    Button Add, Delete, Modify, View, search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing View Variables from activity_main.xml file
        editsearchname = (EditText) findViewById(R.id.edtemployeename);
        editempname = (EditText) findViewById(R.id.editText);
        editempmail = (EditText) findViewById(R.id.editText2);
        editempsalary = (EditText) findViewById(R.id.editText6);
        Add = (Button) findViewById(R.id.btnsave);
        Delete = (Button) findViewById(R.id.btndel);
        Modify = (Button) findViewById(R.id.btnupdate);
        View = (Button) findViewById(R.id.btnselect);
        search = (Button) findViewById(R.id.btnselect);

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                //Check if user has filled in all the values

                if (editempname.getText().toString().trim().length()==0){
                    errorMessage("NAME ERROR ","Kindly fill in your name ") ;
                }else if (editempmail.getText().toString().length()==0) {
                    errorMessage("EMAIL ERROr", "Please enter your email Address");
                }else if (editempsalary.getText().toString().length()==0){
                    errorMessage("ID ERROR","Kindly enter your ID");
                }

                else {
                    //insert data to DB
                    db.execSQL("INSERT INTO Employee VALUES('"+editempname.getText()+"','"+editempmail.getText()+"','"+editempsalary.getText()+"')");
                    errorMessage("QUERY SUCCESS","Data was succefully saved");
                    clear();
                }
            }
        });

        Modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                //code for update data
                if(editsearchname.getText().toString().trim().length()==0)
                {
                    errorMessage("SEARCH", "Enter Employee  Name");
                    return;
                }
                Cursor c=db.rawQuery("SELECT * FROM Employee WHERE EmpName='"+ editsearchname.getText()+"'", null);
                if(c.moveToFirst()) {
                    db.execSQL("UPDATE Employee  SET EmpName ='"+ editempname.getText()+"', EmpMail='"+ editempmail.getText()+"',EmpSalary='"+      editempsalary.getText()+"' WHERE EmpName ='"+editsearchname.getText()+"'");
                    errorMessage("SUCCESS", "Record Modified");
                }
                else
                {
                    errorMessage("ERROR", "Invalid Employee Name");
                }

            }
        });

        Delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                //code for delete data
                if(editsearchname.getText().toString().trim().length()==0)
                {
                    errorMessage("INPUT", " Please enter Employee  Name ");
                    return;
                }
                Cursor c=db.rawQuery("SELECT * FROM Employee WHERE EmpName ='"+ editsearchname.getText()+"'", null);
                if(c.moveToFirst())
                {
                    db.execSQL("DELETE FROM Employee WHERE EmpName ='"+ editsearchname.getText()+"'");
                    errorMessage("SUCCESS", "Record Deleted");
                }
                else
                {
                    errorMessage("ERROR", "Invalid Employee Name ");
                }

            }
        });

        View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                //code for select all data
                Cursor c=db.rawQuery("SELECT * FROM Employee", null);
                if(c.getCount()==0)
                {
                    errorMessage("ERROR", "No records found");
                    return;
                }
                StringBuffer buffer=new StringBuffer();
                while(c.moveToNext())
                {
                    buffer.append("Employee Name: "+c.getString(1)+"\n");
                    buffer.append("Employee Mail: "+c.getString(2)+"\n\n");
                    buffer.append("Employee Salary: "+c.getString(3)+"\n\n");
                }
                errorMessage("SUCCESS", buffer.toString());

            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                //code for select particular data
                if(editsearchname.getText().toString().trim().length()==0)
                {
                    errorMessage("INPUT", "Enter Employee Name");
                    return;
                }
                Cursor c=db.rawQuery("SELECT * FROM Employee WHERE EmpName='"+editsearchname.getText()+"'", null);
                if(c.moveToFirst())
                {
                    editempname.setText(c.getString(1));
                    editempmail.setText(c.getString(2));
                    editempsalary.setText(c.getString(3));
                }
                else
                {
                    errorMessage("ERROR", "Invalid Employee Name");
                }
            }
        });

        //Method for creating a database(Create/View)

        db = openOrCreateDatabase("EmployeesDB", MODE_PRIVATE,null);

        // Query to create a TABLE with three columns

        db.execSQL("CREATE TABLE IF NOT EXISTS Employee(EmpId INTEGER PRIMARY KEY AUTOINCREMENT," +
                "EmpName VARCHAR,EmpMail VARCHAR,EmpSalary VARCHAR);");


        //save data to DB

    }
    //Error message display
    private void errorMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    //clear the editext after saving
    private void clear() {
        editempname.setText("");
        editempmail.setText("");
        editempsalary.setText("");
    }

}


