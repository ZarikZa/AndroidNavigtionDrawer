package com.example.menu;

import android.app.AlertDialog;
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
import android.widget.Toast;


public class SecondFragment extends Fragment {

    private Button button;
    private TextView Schet;
    private int counter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        button = view.findViewById(R.id.button);
        Schet = view.findViewById(R.id.chet);
        registerForContextMenu(button);

        return view;
    }

    @Override
    public void onCreateContextMenu(@NonNull ContextMenu menu, @NonNull View v,
                                    @Nullable ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(Menu.NONE, R.id.menu_item_one, Menu.NONE, "Плюсик");
        menu.add(Menu.NONE, R.id.menu_item_two, Menu.NONE, "Минусик");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu_item_one){
            counter++;
            Schet.setText(String.valueOf(counter));
            return true;
        }
        else if(item.getItemId() == R.id.menu_item_two){
            counter--;
            Schet.setText(String.valueOf(counter));
            return true;
        }
        return false;
    }
}
