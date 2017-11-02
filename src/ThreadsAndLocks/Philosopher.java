package ThreadsAndLocks;

/**
 * Created by Goki_PC on 10/30/2017.
 */
class Philosopher extends Thread
    {
        private int bites = 10;
        private Chopstick left, right;
        private int num;

        public Philosopher(Chopstick left, Chopstick right, int num)
        {
            this.left = left;
            this.right = right;
            this.num = num;
        }

        public void eat()
        {
            System.out.println("Philosopher: " + num + " eating");
            pickUp();
            chew();
            putDown();
        }

        public void pickUp()
        {
            System.out.println("Philosopher: " + this.num + "Picking up");
            this.left.pickUp();
            this.right.pickUp();
        }

        public void chew()
        {
            System.out.println("Chewing");
        }

        public void putDown()
        {
            this.left.putDown();
            this.right.putDown();
        }

        public void run()
        {
            System.out.println("Philosopher : " + this.num + "Started");
            for (int i=0; i<bites; i++)
            {
                eat();
            }
        }
    }
