package com.example.it114watch;
import java.util.LinkedList;
import javax.inject.Inject;
import javax.inject.Singleton;
//creation of singleton to be used across activities
@Singleton
//singleton is a LinkedList of watch objects
public class WatchList extends LinkedList<Watch>
{
    //inject the watches into activity
    @Inject
    WatchList()
    {
        //default
    }

}//end watch list
