package com.example.registrousuariosapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerDay, spinnerMonth, spinnerYear;
    AutoCompleteTextView autoCompleteDocumento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enlazar vistas
        spinnerDay = findViewById(R.id.spinner_day);
        spinnerMonth = findViewById(R.id.spinner_month);
        spinnerYear = findViewById(R.id.spinner_year);
        autoCompleteDocumento = findViewById(R.id.autoCompleteTextViewDocumento);

        // Configurar Spinners de Fecha
        setupDateSpinners();

        // Configurar Spinner de Tipo de Documento
        setupDocumentTypeSpinner();
    }

    private void setupDateSpinners() {
        // --- Días ---
        ArrayList<String> days = new ArrayList<>();
        days.add("Día"); // Hint
        for (int i = 1; i <= 31; i++) {
            days.add(String.valueOf(i));
        }
        ArrayAdapter<String> dayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, days);
        dayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDay.setAdapter(dayAdapter);

        // --- Meses ---
        ArrayList<String> months = new ArrayList<>();
        months.add("Mes"); // Hint
        String[] monthNames = {"Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"};
        Collections.addAll(months, monthNames);
        ArrayAdapter<String> monthAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, months);
        monthAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMonth.setAdapter(monthAdapter);

        // --- Años ---
        ArrayList<String> years = new ArrayList<>();
        years.add("Año"); // Hint
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = currentYear; i >= 1920; i--) {
            years.add(String.valueOf(i));
        }
        ArrayAdapter<String> yearAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, years);
        yearAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerYear.setAdapter(yearAdapter);
    }

    private void setupDocumentTypeSpinner() {
        // Obtiene el array de strings desde los recursos
        String[] tiposDocumento = getResources().getStringArray(R.array.tipos_documento);
        // Crea el adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                tiposDocumento
        );
        // Asigna el adapter al AutoCompleteTextView
        autoCompleteDocumento.setAdapter(adapter);
    }
}