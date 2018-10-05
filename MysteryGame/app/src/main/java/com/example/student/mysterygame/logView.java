package com.example.student.mysterygame;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class logView extends Fragment implements AbsListView.OnItemClickListener {

    AbsListView mListView;
    EditText testField;

    String mmMessage;
    String name;
    String date;

    private static int phoneID;

    boolean hasEnteredPassword;
    boolean isOpened = false;
    boolean authenticationFix = false;
    boolean elseIfFix = false;

    public static ArrayAdapter<LogItems> mArrayAdapter;
    public static ArrayList<LogItems> mArrayList;
    private MainActivity mmActivity;


    public static logView newInstance(int phoneIDINC) {
        logView fragment = new logView();

        phoneID = phoneIDINC;

        return fragment;
    }

    public logView() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            mArrayList = new ArrayList<LogItems>();
            mArrayAdapter = new textLogAdpater(getActivity(), mArrayList);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_log_view, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        mListView = getView().findViewById(R.id.logView);

        mListView.setAdapter(mArrayAdapter);
        mListView.setOnItemClickListener(this);

        testField = getView().findViewById(R.id.editText);
        Button sendButton = getView().findViewById(R.id.sendButton);


        name = "You";
        date = "09/05/2022";


        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Handler handler = new Handler();

                Log.d("Send Button", "Creating a new Log Entry.");



                mmMessage = String.valueOf(testField.getText());
                LogItems newEntry = new LogItems(name, date, mmMessage);
                mArrayAdapter.add(newEntry);
                mArrayAdapter.notifyDataSetChanged();
                mListView.setSelection(mArrayAdapter.getCount()-1);

    //-----------------------------------------CHANGING TO PORT 80-------------------------------------------

                if(Objects.equals(mmMessage, "exe hellowave")){

                    ((MainActivity)getActivity()).changeFragmentToWaveHello();

                }

                if(Objects.equals(mmMessage, "exe ms")){
                    ((MainActivity)getActivity()).changeFragmentToMs();
                }

                if(Objects.equals(mmMessage, "exe maze")){
                    ((MainActivity)getActivity()).changeFragmenttoMazeGame();
                }


                //handles the command for exe phonejack to work.
                if(Objects.equals(mmMessage, "exe phonejack") && !hasEnteredPassword) {
                    populateLogOnStartWith("P03TSy5T3M", "??/??/????", "Must have access to phone systems to initiate jack.");
                }

                if(Objects.equals(mmMessage, "exe phonejack") && hasEnteredPassword){

                    populateLogOnStartWith("P03TSy5T3M", "??/??/????:", "Initiating Jack...");
                    populateLogOnStartWith("P03TSy5T3M", "??/??/????:", "WARNING INTERCEPTING UNKNOWN CONNECTION, STANDBY FOR TRANSFER");

                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            ((MainActivity)getActivity()).changeFragmentforPattern();
                            mListView.setSelection(mArrayAdapter.getCount()-1);

                        }
                    }, 5000);

                }

                InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

                //for mini game maze
                /*if (Objects.equals(mmMessage, "exe mazegame")) {
                    ((MainActivity)getActivity()).changeFragmenttoMazeGame();
                }*/
//----------------------------------------------Commands Available.------------------------------------------------------------
                switch (mmMessage){

                    case("help"):
                        populateLogOnStartWith("UI", "10/12/2018", "clear - Removes all entries in the command line");
                        populateLogOnStartWith("UI", "10/12/2018", "Login *password* - Sends a login request with the acompanying password.");
                        populateLogOnStartWith("UI", "10/12/2018", "exe *program* - Executes a program.");
                        populateLogOnStartWith("UI", "10/12/2018","scan - scans the phone for vulnerabillities");
                        populateLogOnStartWith("UI", "10/12/2018", "help 2 - Page 2 of help.");
                        break;

                    case("help 2"):
                        populateLogOnStartWith("UI", "10/12/2018", "---- Programs List ----");
                        populateLogOnStartWith("UI", "10/12/2018", "hellowave - used to open UDP traffic to phones.");
                        populateLogOnStartWith("UI", "10/12/2018", "phonejack - used to gain access to admin locked files.");
                        populateLogOnStartWith("UI", "10/12/2018", "sneaksnake - used to bypass built in Anti-Virus.");
                        break;

                    case("clear"):
                        mArrayAdapter.clear();
                        break;

                    case ("scan"):
                        //TODO Improve the scan feature.
                        /**
                         * right now inorder for our presentation I'm making the scan feature specifically for one phone.
                         */
                        populateLogOnStartWith("P03TSy5T3M", "??/??/????:", "Scanning .");
                        populateLogOnStartWith("P03TSy5T3M", "??/??/????:", "Scanning ..");
                        populateLogOnStartWith("P03TSy5T3M", "??/??/????:", "Scanning ...");
                        populateLogOnStartWith("P03TSy5T3M", "??/??/????:", "--- FOUND: udp traffic is restricted");
                        populateLogOnStartWith("P03TSy5T3M", "??/??/????:", "--- FOUND: local files are locked by admin authentication");


                        break;

                }
//----------------------------------------------First Time Logging(asking for Authentication)----------------------------------
                if(!hasEnteredPassword && Objects.equals(mmMessage, "Login") || authenticationFix){

                    authenticationFix = true;


                        populateLogOnStartWith("UI", "10/12/2018", "Please Enter Password");




                    if (Objects.equals(mmMessage, "Alpine")) {
                        //UI response is granted
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                populateLogOnStartWith("UI", "10/12/2018:", "Checking...");
                                populateLogOnStartWith("UI", "10/123/2018:", "Access Granted");
                                //TODO fix v that code so it ouputs the names instead of ID.
                                //populateLogOnStartWith("UI", "10/123/2018:", "Welcome to " + phoneID + "'s phone");
                                mListView.setSelection(mArrayAdapter.getCount()-1);
                                authenticationFix = false;
                                populator(phoneID);
                            }
                        }, 1000);

                        hasEnteredPassword = true;

                    } else if(!Objects.equals(mmMessage, "Alpine") && elseIfFix) {

                        populateLogOnStartWith("UI", "10/123/2018:", "checking...");

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                populateLogOnStartWith("UI", "10/123/2018:", "Access denied! Try Again");
                                mListView.setSelection(mArrayAdapter.getCount()-1);

                            }
                        }, 1000);

                        elseIfFix = true;
                        //UI response is denied
                    }
                }
            }


        }

        );


        /**
         * ALL POPULATION REQUESTS FOR THE LOG SHOULD BE PUT BELOW THIS COMMENT.
         */
        Log.d("Log Population", "OnCreate called for LogPopulation");
        introPoputlator(phoneID);





    }

    private void populator (int ID){
        int tempIDholder = ID;

        switch (tempIDholder){

            case 1:
                setFriend1Logs();
                break;
            case 2:
                setFriend2Logs();
                break;
            case 3:
                setFriend3Logs();
                break;
            case 4:
                gameIntroLogs();
        }

    }

    private void introPoputlator (int ID){
        int tempIDholder = ID;

        switch (tempIDholder){

            case 1:
                setFriend1Logs();
                break;
            case 2:
                setFriend2Logs();
                break;
            case 3:
                setFriend3Logs();
                break;
            case 4:
                gameIntroLogs();
        }

    }

    //--------------------------------------Main Logs-----------------------------------------------

    //TODO FIX/SET UP Main Logs

    public void populateMainPhone () {

        populateLogOnStartWith("Float", "09/16/2016:", "Hey you’re Darian from English class right?");
        populateLogOnStartWith("Darian", "09/16/2016:", "Yeah, and you’re “Float” right?");
        populateLogOnStartWith("Float", "09/16/2016:", "yup that’s me, just wanted to ask about the homework for today, cause I couldn’t come to class.");
        populateLogOnStartWith("Darian", "09/16/2016:", "Oh for sure, I think Ms.Robin assigned chapter 15 to 17 for us to read");
        populateLogOnStartWith("Float", "09/16/2016:", "alright cool!");
        populateLogOnStartWith("Darian", "09/16/2016:", "Thanks");
        populateLogOnStartWith("Float", "09/16/2016:", "oh and just so you know Harry told me your number, that’s why I have it.");
        populateLogOnStartWith("Darian", "09/16/2016:", "oh alriht");
        populateLogOnStartWith("Darian", "09/16/2016:", "alright*");
        populateLogOnStartWith("Float", "09/16/2016:", "just didnt want you to think im a stalker");
        populateLogOnStartWith("Darian", "09/16/2016:", "no its alright I wouldnt think that");
        populateLogOnStartWith("Float", "09/16/2016:", "anyways, see you in school i guess. I think we have English 2nd period tomorrow");
        populateLogOnStartWith("Darian", "09/16/2016:", "yeah see you");

        //Add delay here.
        populateLogOnStartWith("Float", "10/16/2016:", "Hey have you finished your Essay yet?");
        populateLogOnStartWith("Darian", "10/16/2016:", "Almost, im just at the revising stage");
        populateLogOnStartWith("Float", "10/16/2016:", "ugh you’re so lucky. I’m barely done. I hate myself for procrastinating so much");
        populateLogOnStartWith("Darian", "10/16/2016:", "Do you want help, I can help you out if you want?");
        populateLogOnStartWith("Float", "10/16/2016:", "no it’s okay");
        populateLogOnStartWith("Darian", "10/16/2016:", "are you sure?");
        populateLogOnStartWith("Float", "10/16/2016:", "yeah, I’m procrastinating talking to you");
        populateLogOnStartWith("Float", "10/16/2016:", "I really need to go and finish this");
        populateLogOnStartWith("Darian", "10/16/2016:", "okay, just message me if you have any questions");
        populateLogOnStartWith("Float", "10/16/2016:", "okay thx.");
        populateLogOnStartWith("Darian", "10/16/2016:", "good luck");

        populateLogOnStartWith("Darian", "04/15/2017:", "Hey I heard what happened with Gavin, are you alright?");
        populateLogOnStartWith("Float", "04/15/2017:", "yeah, im okay");
        populateLogOnStartWith("Float", "04/15/2017:", "I’m still hurt though, I still can’t believe that he could just leave me like that.");
        populateLogOnStartWith("Float", "04/15/2017:", "We were completely fine just a few days ago. We went out on a date, we were happy, he seemed happy");
        populateLogOnStartWith("Float", "04/15/2017:", "I dont know what happened.");
        populateLogOnStartWith("Float", "04/15/2017:", "I asked him if I did anything wrong and he said that he just can’t be with me anymore.");
        populateLogOnStartWith("Float", "04/15/2017:", "I really don’t understand, and I don’t even know what to do right now");
        populateLogOnStartWith("Darian", "04/15/2017:", "I am so sorry.");
        populateLogOnStartWith("Darian", "04/15/2017:", "You guys are still young, we’re all so young still maybe he just really wasn’t ready to be in a serious relationship.");
        populateLogOnStartWith("Float", "04/15/2017:", "yeah maybe. Well i have to go now, I still have lots of things to do.");
        populateLogOnStartWith("Float", "04/15/2017:", "Hopefully there’s a good explanation for everything.");
        populateLogOnStartWith("Darian", "04/15/2017:", "yeah I hope so too.");
        populateLogOnStartWith("Darian", "04/15/2017:", "Well just so you know, if you ever need someone to talk to. I’ll always be here.");
        populateLogOnStartWith("Float", "04/15/2017:", "Yeah thanks so much!");
        populateLogOnStartWith("Darian", "04/15/2017:", "For sure, you know I’ll always have your back");



        //Important Dialogue Birthday: November 27, calculate year
        populateLogOnStartWith("Darian", "05/13/2017:", "Happy Birthday!!!!");
        populateLogOnStartWith("Float", "10/11/2018:", "oh thank you so much!");
        populateLogOnStartWith("Float", "05/13/2017:", "but how did you know it was my birthday?");
        populateLogOnStartWith("Darian", "05/13/2017:", "oh James told me. He mentioned it in a text a couple of days ago");

        //Important: next conversations between these two characters, James will not mention best friends birthday

        populateLogOnStartWith("Float", "05/13/2017:", "oh I wonder how he found out. I swear that kid can’t shut up about anything");
        populateLogOnStartWith("Darian", "05/13/2017:", "yeah you got that right");
        populateLogOnStartWith("Darian", "05/13/2017:", "Meet after school on Monday, I have to give you something");
        populateLogOnStartWith("Float", "05/13/2017:", "What is it?");
        populateLogOnStartWith("Darian", "05/13/2017:", "It’s a surprises, and don’t worry it’s not anything crazy");
        populateLogOnStartWith("Float", "05/13/2017:", "Okay i trust you");

        populateLogOnStartWith("Float", "05/13/2017:", "Anyways I have to go now, but thanks for the birthday greeting!");

        //Important: next conversations between these two characters, James will not mention best friends birthday
        populateLogOnStartWith("UI", "10/11/2018:", "oh that makes sense. I swear that kid can’t shut up about anything");
        populateLogOnStartWith("UI", "10/11/2018:", "yeah you got that right");
        populateLogOnStartWith("UI", "10/11/2018:", "I have to go now, but thanks for the birthday greeting!");

    }


    public void setFriend1Logs() {
        Log.d("Log Population", "OnCreate called for LogPopulation");
        //Without pictures (hints through direction)
        populateLogOnStartWith("UI", "10/11/2018:", "Wait how do i get there again?");
        populateLogOnStartWith("UI", "10/11/2018:", "you’re at west valley right?");
        populateLogOnStartWith("UI", "10/11/2018:", "yeah");
        populateLogOnStartWith("UI", "10/11/2018:", "well then go up until you hit the second street, then turn right.");
        populateLogOnStartWith("UI", "10/11/2018:", "okay then");
        populateLogOnStartWith("UI", "10/11/2018:", "you have to go down the first street that you see, and once you hit the intersection turn right");
        populateLogOnStartWith("UI", "10/11/2018:", "then go right up to Third Avenue and turn left and you’ll be there.");


    }

    public void setFriend2Logs(){

    }

    public void setFriend3Logs(){

    }



    //_---------------------------------------------INTRO LOGS-----------------------------------------------------

    //TODO Set intro Logs

    private void gameIntroLogs(){

                populateLogOnStartWith("Sh3ll", "N/A", "Hey, i know this is weird, but I know what happened");
                populateLogOnStartWith("Sh3ll", "N/A", "Please hear me out");
                populateLogOnStartWith("Sh3ll", "N/A", "I know what happened to Float and I can help");
                populateLogOnStartWith("Sh3ll", "N/A", "I sent you this app to help you because I know that you are the only one that can be trusted.");
                populateLogOnStartWith("Sh3ll", "N/A", "This phone has the power to connect and hack through different phones breaking down any firewalls, proxies and passwords.");
                populateLogOnStartWith("Sh3ll", "N/A", "I know this sounds absurd but this is the only way to get your friend back");
                populateLogOnStartWith("Sh3ll", "N/A", "Typing /help will grant you access to the commands you will need for the game");
                populateLogOnStartWith("Sh3ll", "N/A", "I was able to infiltrate Float’s phone already, you will be automatically connected to her if you select her device and enter the password: 6bHR8X. You will have access to her conversations with Darian.");
                populateLogOnStartWith("Sh3ll", "N/A", "My next target was gonna be Darian. But i no longer have time They are after me, and they will not stop until I’m gone and out of their way.");
                populateLogOnStartWith("Sh3ll", "N/A", "Everything is now up to you, I’m sorry I could not be of much help");
                populateLogOnStartWith("Sh3ll", "N/A", "This is the most I could do");
                populateLogOnStartWith("Sh3ll", "N/A", "Float is very important to me, and you are the only one that I can ask for help");
                populateLogOnStartWith("Sh3ll", "N/A", "Good luck... and I hope that you can find her.");
                populateLogOnStartWith("P03TSy5T3M", "??/??/????:", "Connecting to Device…….");
                populateLogOnStartWith("P03TSy5T3M", "??/??/????:", "Loading…….");
                populateLogOnStartWith("P03TSy5T3M", "??/??/????:","Access Granted (Float’s phone)");
    }

    private void friend1IntroLogs(){

    }

    private void friend2IntroLogs(){

    }

    private void friend3IntroLogs(){

    }


    private void populateLogOnStartWith(String name, String date, String entry) {

        LogItems newEntry = new LogItems(name, date, entry);
        mArrayAdapter.add(newEntry);
        mArrayAdapter.notifyDataSetChanged();
        mListView.setSelection(mArrayAdapter.getCount()-1);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        

    }
}
