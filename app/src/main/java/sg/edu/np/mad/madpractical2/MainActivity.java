package sg.edu.np.mad.madpractical2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Initialise a new User object
        User user = new User("John Doe", "MAD Developer", 1, false);

        // gets the TextViews and Button from the layout
        TextView tvName = findViewById(R.id.textview2);
        TextView tvDescription = findViewById(R.id.textview3);
        Button btnFollow = findViewById(R.id.button1);

        // set the textviews with the user's name, description and default button message
        tvName.setText(user.name);
        tvDescription.setText(user.description);
        btnFollow.setText("Follow");

        btnFollow.setOnClickListener(view -> {
            if(user.followed){
                btnFollow.setText("Unfollow");
            } else {
                btnFollow.setText("Follow");
            }
            user.followed = !user.followed;
        });


    }
}