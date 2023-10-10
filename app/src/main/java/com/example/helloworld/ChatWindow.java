package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatWindow extends AppCompatActivity {

    private ListView chatListView;
    private EditText chatEditText;
    private Button chatSendButton;
    private ArrayList<String> chatMessages = new ArrayList<>();
    String logText = "ListItemsActivity :";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_window);
        chatListView = findViewById(R.id.chat_list_view);
        chatEditText = findViewById(R.id.chat_edit_text);
        chatSendButton = findViewById(R.id.chat_send_button);
        final ChatAdapter messageAdapter = new ChatAdapter( this );

        chatListView.setAdapter (messageAdapter);

        chatSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = chatEditText.getText().toString();
                chatMessages.add(message);
                chatEditText.setText("");
                messageAdapter.notifyDataSetChanged();
            }
        });
    }

    private class ChatAdapter extends ArrayAdapter<String>
    {
        public ChatAdapter(Context context)
        {
            super(context, 0);
        }

        public int getCount()
        {
            return chatMessages.size(); // Return the number of items in array of messages
        }

        public String getItem(int position)
        {
            return chatMessages.get(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            LayoutInflater inflater = ChatWindow.this.getLayoutInflater();
            View result;

            Log.i(logText, Integer.toString(position));
            if(position%2 == 0)
                result = inflater.inflate(R.layout.chat_row_outgoing, null);
            else
                result = inflater.inflate(R.layout.chat_row_incoming, null);

            TextView message = result.findViewById(R.id.message_text);
            message.setText( getItem(position) ); // get the string at position
            return result;
        }

    }

}