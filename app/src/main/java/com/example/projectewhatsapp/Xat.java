package com.example.projectewhatsapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Xat extends AppCompatActivity {

    private ListView mListView;
    private FloatingActionButton mButtonSend;
    private EditText mEditTextMessage;
    private ChatMessageAdapter mAdapter;
    private ImageButton buttonGaleria;
    private TextView estat;
    private int acabat = 0;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xat);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Eduard Toda");
        getSupportActionBar().setIcon(R.drawable.eduardtoda);

        mListView = findViewById(R.id.listView);
        mButtonSend = findViewById(R.id.btn_send);
        mEditTextMessage = findViewById(R.id.et_message);
        estat = findViewById(R.id.estat);
        buttonGaleria = findViewById(R.id.btn_galeria);

        mAdapter = new ChatMessageAdapter(this, new ArrayList<ChatMessage>());
        mListView.setAdapter(mAdapter);

        mimicOtherMessage("Escolta Quitèria, si us plau, vés a la biblioteca i mira’m què vol dir aquest jeroglífic.", 0);

        estat.setText("Escrivint...");
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mimicOtherMessage("Estic a la tomba de Sennedjem i em vaig deixar les taules de transcripció de jeroglífics al despatx.", 0);
                estat.setText("Enviant imatges...");
            }
        }, 3000);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mimicOtherMessage("", R.drawable.jero1);
                mimicOtherMessage("", R.drawable.jero2);
                mimicOtherMessage("", R.drawable.jero3);
                estat.setText("Connectat");
                tornarAvall();
            }
        }, 6000);
        acabat = 1;

        mButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = mEditTextMessage.getText().toString();
                if(!message.equalsIgnoreCase("")){
                    sendMessage(message);
                    mEditTextMessage.setText("");
                    mListView.setSelection(mAdapter.getCount() - 1);

                    Handler handler = new Handler();

                    //1a resposta Aqui jeu Sennedjem, fill de Jabejnet i Tahennu, que va servir amb honor i lleialtat a Ses Alteses Seti i Ramsés, fins al moment de la seva mort
                    if(message.equalsIgnoreCase("hola") && acabat == 1){

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                estat.setText("Escrivint...");
                            }
                        }, 1000);

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mimicOtherMessage("Ja fa uns dies que li dono voltes a un tema…" + new String(Character.toChars(0x1F914))+ "No creus que a la sala blava falta un quadre que representi algun dels espais del castell?", 0);

                                tornarAvall();
                            }
                        }, 3000);

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mimicOtherMessage("Tenim trossos de parets encara molt buits i encara no tenim un que representi la nostra casa.", 0);

                                tornarAvall();
                            }
                        }, 5000);

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mimicOtherMessage("Penso que a la mare li faria il·lusió veure el pati de casa ben colorit a la paret.", 0);

                                estat.setText("Connectat");
                                tornarAvall();
                            }
                        }, 7000);

                        acabat = 2;
                    }

                    //2a resposta "Senyor Toda, a continuació li envio diferents propostes de pintura, espero que us agradi..!"
                    if(message.equalsIgnoreCase("hola2") && acabat == 2){


                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                estat.setText("Escrivint...");
                            }
                        }, 1000);

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mimicOtherMessage("Quitèria, acabo d’enregistrar un vídeo pel canal de Youtube, mira’l a veure què et sembla:", 0);
                                mimicOtherMessage("https://youtu.be/crSo3Xwn3yA", 0);
                                estat.setText("Connectat");
                                tornarAvall();
                            }
                        }, 3000);

                        acabat = 3;
                    }

                    //3a resposta "El vídeo està genial, Sr. Toda! Ens ha encantat!"
                    if(message.equalsIgnoreCase("hola3") && acabat == 3){
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                estat.setText("Escrivint...");
                            }
                        }, 1000);

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mimicOtherMessage("Quitèria, crec que la mare m’ha tornat a tocar la meva maleta... la pots guardar al seu lloc concret?", 0);

                                tornarAvall();
                            }
                        }, 3000);

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mimicOtherMessage("Espero no haver-te de dir on és, ningú es coneix la casa tant com tu.", 0);
                                estat.setText("Connectat");
                                tornarAvall();
                            }
                        }, 5000);

                        acabat = 4;
                    }

                    //4a resposta “La maleta ja està al seu lloc, senyor Toda”
                    if(message.equalsIgnoreCase("hola4") && acabat == 4){
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                estat.setText("Escrivint...");
                            }
                        }, 1000);

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mimicOtherMessage("Quitèria, si us plau, fes-me el favor d’anar a la sala dels mosaics, que la meva mare m’ha dit que hi ha hagut un accident.\n" +
                                        "Espero que no s’hagi fet malbé res.", 0);
                                estat.setText("Connectat");
                                tornarAvall();
                            }
                        }, 3000);

                        acabat = 5;
                    }

                    //5a resposta "No es preocupi, Sr, Toda. El mossaic està en perfecte estat!"
                    if(message.equalsIgnoreCase("hola5") && acabat == 5){
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                estat.setText("Escrivint...");
                            }
                        }, 1000);

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mimicOtherMessage("Tens tota la raó, no he de preocupar-me tan de les tasques de casa quan surti de viatge.", 0);
                                tornarAvall();
                            }
                        }, 3000);

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mimicOtherMessage("Però només una coseta més... "+new String(Character.toChars(0x1F601)), 0);

                                tornarAvall();
                            }
                        }, 5000);

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mimicOtherMessage("Quin temps fa per allí? M’estàs regant les plantes del pati?", 0);
                                estat.setText("Connectat");
                                tornarAvall();
                            }
                        }, 7000);

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                estat.setText("Escrivint...");
                            }
                        }, 10000);

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                mimicOtherMessage("Veig que tot està fantàstic! Moltes gràcies per les fotos!", 0);
                                estat.setText("Connectat");
                                tornarAvall();
                            }
                        }, 11000);
                    }
                }



            }
        });

        buttonGaleria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obrirGaleria();
            }
        });
    }

    private void obrirGaleria() {
        Intent galeria = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(galeria, PICK_IMAGE);
    }

    private void tornarAvall(){
        mListView.post(new Runnable(){
            public void run() {
                mListView.setSelection(mListView.getCount() - 1);
            }});
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            ChatMessage chatMessage = new ChatMessage("", 0, true, imageUri);
            mAdapter.add(chatMessage);
            tornarAvall();
        }
    }

    private void sendMessage(String message) {
        ChatMessage chatMessage = new ChatMessage(message, 0, true, null);
        mAdapter.add(chatMessage);
    }

    private void mimicOtherMessage(String message, int drawable) {
        ChatMessage chatMessage = new ChatMessage(message, drawable, false, null);
        mAdapter.add(chatMessage);
    }

    @Override
    public void onBackPressed() {

    }
}