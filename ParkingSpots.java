package com.example.danny.parkingapplication;

public class ParkingSpots {



    static int[][] multi = new int[7][6];











    public void reset(boolean i) {
        if (i) {

            for (int j = 0; j<7; j++)
            {
                for (int k = 0; k<6; k++)
                {
                    multi[j][k] = 1;
                }
            }
        }
        }







}
