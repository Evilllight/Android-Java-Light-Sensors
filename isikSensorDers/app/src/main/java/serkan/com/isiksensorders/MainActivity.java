package serkan.com.isiksensorders;

import android.content.Context;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView image;
    TextView txtSensor;
    Sensor isikSensoru;
    SensorManager sensorYoneticisi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSensor = (TextView) findViewById(R.id.textView1);
        image = (ImageView) findViewById(R.id.imageView);


        sensorYoneticisi = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        isikSensoru = sensorYoneticisi.getDefaultSensor(Sensor.TYPE_LIGHT);
        sensorYoneticisi.registerListener(sensorDinleyicisi,isikSensoru,sensorYoneticisi.SENSOR_DELAY_FASTEST);

    }

        SensorEventListener sensorDinleyicisi= new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {

                if(event.sensor.getType()==Sensor.TYPE_LIGHT) {
                    txtSensor.setText("Işık Sensör Seviyesi" + event.values[0]);

                    if(event.values[0]<25){
                        image.setBackgroundColor(Color.BLUE);
                    }
                    else if(event.values[0]<50){
                        image.setBackgroundColor(Color.BLACK);
                    }
                    else
                    {
                        image.setBackgroundColor(Color.RED);
                    }


                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };





    }

