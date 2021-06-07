package edu.neu.madcourse.madsu21_martapalermo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.recyclerview.widget.RecyclerView;

public class RecyclerHolder extends RecyclerView.ViewHolder {

    public TextView itemName;
    public TextView itemDescription;

    public RecyclerHolder(View itemView, final ItemClickListener listener, Context context) {
        super(itemView);

        // linkName
        itemName = itemView.findViewById(R.id.item_name);
        // linkURL
        itemDescription = itemView.findViewById(R.id.item_description);

        itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                if (listener != null) {
//                    int position = getLayoutPosition();
//                    if (position != RecyclerView.NO_POSITION) {
//                        listener.onItemClick(position);
//                    }
//                }
                if (listener != null) {
                    Uri linkToWeb = Uri.parse(m_Text);

                    if (!m_Text.startsWith("http://") && !m_Text.startsWith("https://")) {
                        linkToWeb = Uri.parse("http://" + m_Text);
                    }
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, linkToWeb);
                    try {
                        context.startActivity(browserIntent);
                    } catch (Exception e) {
                        Toast.makeText(v.getContext(), "The url was invalid. Please try again ", Toast.LENGTH_LONG);
                    }
                }
            }
        });

    }

}
