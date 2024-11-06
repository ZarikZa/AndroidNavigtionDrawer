package com.example.menu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class First extends Fragment {

    private Button button;
    private TextView Schet;
    private int counter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        button = view.findViewById(R.id.button);
        Schet = view.findViewById(R.id.chet);
        registerForContextMenu(button);

        return view;
    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v,
                                    @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(Menu.NONE, R.id.menu_item_one, Menu.NONE, "1 текст");
        menu.add(Menu.NONE, R.id.menu_item_two, Menu.NONE, "2 текст");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu_item_one){
            Schet.setText("1 текст");
            return true;
        }
        else if(item.getItemId() == R.id.menu_item_two){
            Schet.setText("2 текст");
            return true;
        }
        return false;
    }
}