package com.coderfaysal.aboutfruits;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    RecyclerView it_recycle;
    HashMap<String, String> hashMap;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        it_recycle = findViewById(R.id.it_recycle);

        FLOWER();


        MyAdapter myAdapter = new MyAdapter();
        it_recycle.setAdapter(myAdapter);
        it_recycle.setLayoutManager(new LinearLayoutManager(MainActivity.this));


    }



    public void FLOWER(){

        hashMap = new HashMap<>();
        hashMap.put("img", "https://i.ibb.co/VWs4t22/pexels-messala-ciulla-2935021.jpg");
        hashMap.put("title", "Mango");
        hashMap.put("desc", "The term mango refers to the plant Magnifier indic as well as to its fruit. The plant, which is a member of the family Anacardiaceae, is an evergreen tree. Its fruit varies in appearance and is one of the most important and widely cultivated fruits of the tropical world. \nThe mango is considered indigenous to southern Asia, and mango trees can be found today in Brazil, the West Indies, Florida, and other tropical environments. The mango does not require any particular soil, but the finer varieties yield good crops only where there is a well-defined dry season to stimulate fruit production. \nMango fruits are a rich source of vitamins A, C, and D. There is also research that suggests that mangoes can help control weight, fight cancer, and improve digestion. Mangoes have high sugar content compared with other fruits, however, which may pose risks to some people. \nBecause there are many different varieties that require different growth conditions, mangoes are generally available year-round. However, June and July are considered the best time to buy mangoes in the United States.");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("img", "https://i.ibb.co/bsSk7Lg/pexels-aleksandar-pasaric-2872755.jpg");
        hashMap.put("title", "Banana");
        hashMap.put("desc", "Banana, fruit of the genus Musa, of the family Musaceae, one of the most important fruit crops of the world. The banana is grown in the tropics, and, though it is most widely consumed in those regions, it is valued worldwide for its flavour, nutritional value, and availability throughout the year. Cavendish, or dessert, bananas are most commonly eaten fresh, though they may be fried or mashed and chilled in pies or puddings. They may also be used to flavour muffins, cakes, or breads. Cooking varieties, or plantains, are starchy rather than sweet and are grown extensively as a staple food source in tropical regions; they are cooked when ripe or immature. A ripe fruit contains as much as 22 percent of carbohydrate and is high in dietary fibre, potassium, manganese, and vitamins B6 and C.");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("img", "https://i.ibb.co/qm7bv4d/pexels-bruno-scramgnon-23042.jpg");
        hashMap.put("title", "Grapes");
        hashMap.put("desc", "Grape, (genus Vitis), genus of about 60 to 80 species of vining plants in the family Vitaceae, native to the north temperate zone, including varieties that may be eaten as table fruit, dried to produce raisins, or crushed to make grape juice or wine. The grape is usually a woody vine, climbing by means of tendrils (modified branches) and when untrained often reaching a length of 17 metres (56 feet) or more. In arid regions it may form an almost erect shrub. The edible leaves are alternate, palmately lobed, and always tooth-edged. Small greenish flowers, in clusters, precede the fruit.");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("img", "https://i.ibb.co/mSTK90H/pexels-pixabay-206959.jpg");
        hashMap.put("title", "Apple");
        hashMap.put("desc", "Apple, (Malus domestica), domesticated tree and fruit of the rose family (Rosaceae), one of the most widely cultivated tree fruits. Apples are predominantly grown for sale as fresh fruit, though apples are also used commercially for vinegar, juice, jelly, applesauce, and apple butter and are canned as pie stock. A significant portion of the global crop also is used for cider, wine, and brandy. Fresh apples are eaten raw or cooked. There are a variety of ways in which cooked apples are used; frequently, they are used as a pastry filling, apple pie being perhaps the archetypal American dessert. Especially");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("img", "https://i.ibb.co/gMsR0qc/pexels-lisa-fotios-1002543.jpg");
        hashMap.put("title", "Lemon");
        hashMap.put("desc", "Lemon, small tree or spreading bush of the rue family (Rutaceae) and its edible fruit. Lemon juice is a characteristic ingredient in many pastries and desserts, such as tarts and the traditional American lemon meringue pie. The distinctive astringent flavour of the fruit, either fresh or preserved, is also used to enhance many poultry, fish, and vegetable dishes worldwide. Lemonade, made with lemon, sugar, and water, is a popular warm-weather beverage, and the juice itself is commonly added to tea. Citric acid may amount to 5 percent or more by weight of the lemon’s juice, which is also rich in vitamin C and contains smaller amounts of the B vitamins, particularly thiamin, riboflavin, and niacin.");
        arrayList.add(hashMap);


    }


    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            LayoutInflater layoutInflater = getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.items, parent, false);

            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            hashMap = arrayList.get(position);
            String imagesURL = hashMap.get("img");
            String name = hashMap.get("title");
            String dec = hashMap.get("desc");

            holder.it_name.setText(name);
            Picasso.get().load(imagesURL).into(holder.it_img);

            holder.click_lay.setOnClickListener(view -> {

                Details.TITLE = name;
                Details.IMAGE = imagesURL;
                Details.DESC = dec;
                startActivity(new Intent(MainActivity.this, Details.class));

            });

        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }

        private class MyViewHolder extends RecyclerView.ViewHolder{

            LinearLayout click_lay;
            ImageView it_img;
            TextView it_name;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);

                click_lay = itemView.findViewById(R.id.click_lay);
                it_img = itemView.findViewById(R.id.it_img);
                it_name = itemView.findViewById(R.id.it_name);


            }
        }

    }


}