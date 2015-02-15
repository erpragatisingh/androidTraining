package in.wptrafficanalyzer.filereadwritecache;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private final String TEMP_FILE_NAME = "pra_temp_file1.txt";
	EditText etContent;
	File tempFile;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        /** Getting reference to btn_save of the layout activity_main */
        Button btnSave = (Button) findViewById(R.id.btn_save);
        
        /** Getting Cache Directory */
        File cDir = getBaseContext().getCacheDir();
        
        /** Getting a reference to temporary file, if created earlier */
        tempFile = new File(cDir.getPath() + "/" + TEMP_FILE_NAME) ;
        
        /** Getting reference to edittext et_content */
        etContent = (EditText) findViewById(R.id.et_content);

        
        String strLine="";
        StringBuilder text = new StringBuilder();
        
        /** Reading contents of the temporary file, if already exists */
        try {
			FileReader fReader = new FileReader(tempFile);
			BufferedReader bReader = new BufferedReader(fReader);

            /** Reading the contents of the file , line by line */
            while( (strLine=bReader.readLine()) != null  ){
                    text.append(strLine+"\n");
            }
			
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
        
        /** Setting content from file */
        etContent.setText(text);        
        
        
        /** Defining click event listener for the button btn_save */
        OnClickListener saveClickListener = new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
                FileWriter writer=null;
                try {
                        writer = new FileWriter(tempFile);

                        /** Saving the contents to the file*/
                        writer.write(etContent.getText().toString());

                        /** Closing the writer object */
                        writer.close();              
                        
                        Toast.makeText(getBaseContext(), "Temporarily saved contents in " + tempFile.getPath(), Toast.LENGTH_LONG).show();
                        etContent.append(tempFile.getPath());

                } catch (IOException e) {
                        e.printStackTrace();
                }
                
			}
		};
		
		/** Setting the click event listener for the button btn_save */
		btnSave.setOnClickListener(saveClickListener);
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
