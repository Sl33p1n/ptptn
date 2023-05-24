package com.example.ptptn

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val about = findViewById<Button>(R.id.buttonAboutUs)
        val studentID = findViewById<EditText>(R.id.editStudentID)
        val university = findViewById<Spinner>(R.id.spinnerUni)
        val program = findViewById<Spinner>(R.id.spinnerProgram)
        val cgpa = findViewById<Spinner>(R.id.spinnerCGPA)
        val reset = findViewById<Button>(R.id.buttonReset)
        val check = findViewById<Button>(R.id.buttonCheck)
        val result = findViewById<TextView>(R.id.textViewResult)
        val honour = findViewById<TextView>(R.id.textViewHonour)


        check.setOnClickListener {
            if (studentID.text.isEmpty()){
                studentID.setError(getString(R.string.error))
                return@setOnClickListener
            }

            if (cgpa.selectedItemPosition == 0){
                honour.text = "First Class"
            }
            else if (cgpa.selectedItemPosition == 1){
                honour.text = "Second Class (Upper Division)"
            }
            else if (cgpa.selectedItemPosition == 2) {
                honour.text = "Second Class (Lower Division)"
            }
            else{
                honour.text = "Third Class"
            }


            if (university.selectedItemPosition == 0 && cgpa.selectedItemPosition == 0 && program.selectedItemPosition == 0 ){

                result.text = getString(R.string.qualify)
            }
            else if (university.selectedItemPosition == 1 && cgpa.selectedItemPosition == 0 && program.selectedItemPosition == 0){

                result.text = getString(R.string.qualify)
            }
            else {

                result.text = getString(R.string.disqualify)

            }

        }

        about.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://www.ptptn.gov.my")
            startActivity(intent)
        }

        reset.setOnClickListener {
            studentID.text.clear()
            university.setSelection(0)
            program.setSelection(0)
            cgpa.setSelection(0)
            result.text = ""
            honour.text = ""

        }
    }
}