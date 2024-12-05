package org.example;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.web.client.RestTemplate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        // Jokes API
//        System.out.println("Random Joke: ");
//        String jsonRandom = new RestTemplate().getForObject("https://official-joke-api.appspot.com/jokes/random", String.class);
//
//        JsonObject response = JsonParser.parseString(jsonRandom).getAsJsonObject();
//        String aRandom = response.get("setup").getAsString();
//        String bRandom = response.get("punchline").getAsString();
//        System.out.println(aRandom + " " + bRandom + "\n");
//
//        System.out.println("Ten jokes:");
//        String jsonTen = new RestTemplate().getForObject("https://official-joke-api.appspot.com/jokes/ten", String.class);
//
//        JsonArray responses = JsonParser.parseString(jsonTen).getAsJsonArray();
//        for(JsonElement joke: responses){
//            String aTen = joke.getAsJsonObject().get("setup").getAsString();
//            String bTen = joke.getAsJsonObject().get("punchline").getAsString();
//            System.out.println(aTen + " " + bTen);
//        }

        // Superhero API
        String jsonDeadpool = new RestTemplate().getForObject("https://superheroapi.com/api/8ceec6e016d47b7d4a11031e2e413b03/213", String.class);
        String jsonWolverine = new RestTemplate().getForObject("https://superheroapi.com/api/8ceec6e016d47b7d4a11031e2e413b03/717", String.class);

        JsonObject responseDeadpool = JsonParser.parseString(jsonDeadpool).getAsJsonObject();
        JsonObject responseWolverine = JsonParser.parseString(jsonWolverine).getAsJsonObject();

//        int deadpoolStrength = responseDeadpool.getAsJsonObject("powerstats").get("strength").getAsInt();
//        int wolverineStrength = responseWolverine.getAsJsonObject("powerstats").get("strength").getAsInt();

        int deadpoolPowerstats = getPowerstats(responseDeadpool);
        int wolverinePowerstats = getPowerstats(responseWolverine);

        System.out.println(responseDeadpool);
        System.out.println(responseWolverine);

        System.out.println(responseDeadpool.get("name") + " has total powerstats of " + deadpoolPowerstats);
        System.out.println(responseWolverine.get("name") + " has total powerstats of " + wolverinePowerstats);

        if(deadpoolPowerstats > wolverinePowerstats){
            System.out.println("Deadpool is stronger");
        }else if(deadpoolPowerstats < wolverinePowerstats){
            System.out.println("Wolverine is stronger");
        }else{
            System.out.println("They have equal strength");
        }
    }

    public static int getPowerstats(JsonObject hero){
        int totalPowerstats = 0;
        JsonObject powerstats = hero.getAsJsonObject("powerstats");
        totalPowerstats = totalPowerstats
                + powerstats.get("intelligence").getAsInt()
                + powerstats.get("strength").getAsInt()
                + powerstats.get("speed").getAsInt()
                + powerstats.get("durability").getAsInt()
                + powerstats.get("power").getAsInt()
                + powerstats.get("combat").getAsInt();

        return totalPowerstats;
    }
}