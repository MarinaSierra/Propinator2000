package com.msierra.propinatron2000;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button[] buttons;
    private String precio="";
    private TextView numb, total;
    private RadioGroup radio;
    private Button delete, calc;
    private double n, newPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        buttons=new Button[]{
            findViewById(R.id.n0),
            findViewById(R.id.n1),
            findViewById(R.id.n2),
            findViewById(R.id.n3),
            findViewById(R.id.n4),
            findViewById(R.id.n5),
            findViewById(R.id.n6),
            findViewById(R.id.n7),
            findViewById(R.id.n8),
            findViewById(R.id.n9)
        };

        calc=findViewById(R.id.calcu);
        delete=findViewById(R.id.borrar);
        numb=findViewById(R.id.numeros);
        total=findViewById(R.id.result);
        radio=findViewById(R.id.gruporadio);

        for (Button i:
             buttons) {
            i.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    precio += i.getText().toString();
                    numb.setText(precio);
                }
            });
        }

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                precio = "";
                numb.setText(precio);
                total.setText("");
            }
        });
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int id=radio.getCheckedRadioButtonId();
                RadioButton op=findViewById(id);
                String value=op.getText().toString();

                n=Double.parseDouble(numb.getText().toString());

                switch(value){
                    case "Excelente":
                        newPrice=n*1.50;
                        total.setText(newPrice+" ");
                        break;
                    case "Normal":
                        newPrice=n*1.10;
                        total.setText(newPrice+" ");
                        break;
                    case "Mal":
                        newPrice=n*0.90;
                        total.setText(newPrice+" ");
                        break;
                    default:
                        total.setText("AAA");
                }
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}