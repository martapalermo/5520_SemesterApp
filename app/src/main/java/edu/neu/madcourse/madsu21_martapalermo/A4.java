package edu.neu.madcourse.madsu21_martapalermo;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Random;

public class A4 extends AppCompatActivity {

    private ArrayList<ItemCard> itemList = new ArrayList<>();
    private RecyclerView recyclerView;
    private RviewAdapter rviewAdapter;
    private RecyclerView.LayoutManager rLayoutManager;
    
    private static final String KEY_OF_INSTANCE = "KEY_OF_INSTANCE";
    private static final String NUMBER_OF_ITEMS = "NUMBER_OF_ITEMS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linkcollector);

        init(savedInstanceState);
        
        FloatingActionButton fab = findViewById(R.id.fabAdd);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int pos = 0;
                addItem(pos);
            }
        });

        fab.setOnClickListener(v -> Snackbar.make(v, "Add url link here",
                Snackbar.LENGTH_LONG).setAction("Action", null).show());
    }

    private void init(Bundle savedInstanceState) {
        initialItemData(savedInstanceState);
        createRecyclerView();
    }

    private void createRecyclerView() {
        rLayoutManager = new LinearLayoutManager(this);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        rviewAdapter = new RviewAdapter(itemList);
        ItemClickListener itemClickListener = new ItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //attributions bond to the item has been changed
                itemList.get(position).onItemClick(position);

                rviewAdapter.notifyItemChanged(position);
            }

            @Override
            public void onCheckBoxClick(int position) {
                //attributions bond to the item has been changed
                itemList.get(position).onCheckBoxClick(position);

                rviewAdapter.notifyItemChanged(position);
            }
        };
        rviewAdapter.setOnItemClickListener(itemClickListener);

        recyclerView.setAdapter(rviewAdapter);
        recyclerView.setLayoutManager(rLayoutManager);
    }

    private void initialItemData(Bundle savedInstanceState) {
        // Not the first time to open this Activity
        if (savedInstanceState != null && savedInstanceState.containsKey(NUMBER_OF_ITEMS)) {
            if (itemList == null || itemList.size() == 0) {

                int size = savedInstanceState.getInt(NUMBER_OF_ITEMS);

                // Retrieve keys we stored in the instance
                for (int i = 0; i < size; i++) {
                    Integer imgId = savedInstanceState.getInt(KEY_OF_INSTANCE + i + "0");
                    String itemName = savedInstanceState.getString(KEY_OF_INSTANCE + i + "1");
                    String itemDesc = savedInstanceState.getString(KEY_OF_INSTANCE + i + "2");
                    boolean isChecked = savedInstanceState.getBoolean(KEY_OF_INSTANCE + i + "3");

                    // We need to make sure names such as "XXX(checked)" will not duplicate
                    // Use a tricky way to solve this problem, not the best though
                    if (isChecked) {
                        itemName = itemName.substring(0, itemName.lastIndexOf("("));
                    }
                    ItemCard itemCard = new ItemCard(imgId, itemName, itemDesc, isChecked);

                    itemList.add(itemCard);
                }
            }
        }

    }

    private void addItem(int position) {
        itemList.add(position, new ItemCard(R.drawable.empty, "No Logo item",
                "Item id: "
                        + Math.abs(new Random().nextInt(100000)), false));
        Toast.makeText(A4.this, "Add an item", Toast.LENGTH_SHORT).show();

        rviewAdapter.notifyItemInserted(position);
    }



}
