package com.forpoint.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/*界面有两个按钮，点击时分别弹出提示对话框和登录对话框，
其中登录对话框要求用户输入UserId和Password，
如果UserId和Password不是“abc”、“123”，
则使用Toast提示错误，否则提示成功。
 */
public class MainActivity extends AppCompatActivity {


    EditText editText1;
    EditText editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btn = (Button) this.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                final View DialogView = inflater.inflate(R.layout.login, null);
                builder.setView(inflater.inflate(R.layout.login, null))
                        .setTitle("Login")
                        .setView(DialogView)
                        .setPositiveButton("login", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                // login
                                editText1 = (EditText) DialogView.findViewById(R.id.editTextUserId);
                                editText2 = (EditText) DialogView.findViewById(R.id.editTextPwd);
                                String strId = editText1.getText().toString().trim();
                                String strPassword = editText2.getText().toString().trim();
                                if(strId.equals("abc") && strPassword.equals("123"))
                                {
                                    Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_LONG).show();
                                }
                                else
                                {
                                    Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_LONG).show();
                                }
                            }
                        })
                        .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //cancel
                                Toast.makeText(MainActivity.this, "未登录", Toast.LENGTH_LONG).show();
                            }
                        });
                builder.show();
            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
