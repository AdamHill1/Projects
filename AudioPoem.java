    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
    package HillAdam_Assignment1_ITIS1213;

    import BookClasses.Sound;
    import java.util.Random;

    /**
     * This class contains methods for mixing up the words in an audio file and
     * creating sound poetry out of them. It contains many stub methods which need
     * to be completed as part of Assignment 1.
     *
     * @author clatulip, (Adam Hill)
     */
    public class AudioPoem {

        static final int MAX_NUM_WORDS = 100;
        static private Sound[] myWordArray = new Sound[MAX_NUM_WORDS];

        static private int numWords = 0;

    /**
     *constructor to create a word array of the words in the sound passed in
     * @param originalSource the original sound
     * @param spliceArray decides where to splice the sound
     * @param numSplicePoints number of point to splice
     */
    public AudioPoem(Sound originalSource, int[] spliceArray, int numSplicePoints) {

            // break the sound into sepearate words, copying each into the word array
            for (int i = 0, j = 0; i < numSplicePoints; i = i + 2, j++) {
                myWordArray[j] = new Sound(spliceArray[i + 1] - spliceArray[i]);
                for (int x = spliceArray[i], y = 0; x < spliceArray[i + 1]; x++, y++) {
                    myWordArray[j].setSampleValueAt(y, originalSource.getSampleValueAt(x));
                }
                numWords++;
            }

        }

        /**
         * Plays the words, in order with a 200 millisecond pause between each
         *
         * @throws InterruptedException
         */
        public void play() throws InterruptedException {
            // play the words in order
            for (int i = 0; i < numWords; i++) {
                myWordArray[i].blockingPlay();
                Thread.sleep(200);
            }
        }

        /**
         * Plays the words, in order with a parameter-specified pause between each
         *
         * @param pause the number of milliseconds to pause between words
         * @throws InterruptedException
         */
        public void play(int pause) throws InterruptedException {
            // play the words in order and use the pause param in sleep
            for (int i = 0; i < numWords; i++) {
                myWordArray[i].blockingPlay();
                Thread.sleep(pause);
            }
        }
        /**
         * Plays the words, in order with a parameter-specified pause between each and writes the resulting sound out to a file
         * @param pause the number of milliseconds to pause between words
         * @param filename the name of the file to write
         * @param path the path where the file should be written
         * @throws InterruptedException 
         */
        public void play(int pause, String filename, String path) throws InterruptedException {
            int total = 0; //total num samples
            int temp = (int)((pause/1000.0)*44100);
            //get the total num of samples for the words
            for (int i =0; i<numWords; i++ ){
                total = total+ myWordArray[i].getNumSamples();
            }
            total= total +(temp*(numWords));
            Sound s = new Sound(total);
            
            int k = 0; // sample your at
            int l = 0; // word you are att
            for (int i =0; i<numWords; i++){
                //set the words and pauses
                for(int j=0; j<myWordArray[i].getNumSamples();j++){
                    s.setSampleValueAt(k, myWordArray[i].getSampleValueAt(j));
                    k++;
                }
                if(l!=numWords){
                    for(int w=0; w<temp; w++){
                    s.setSampleValueAt(k, 0);
                    k++;
                    }                 
                }
                l++;
            }
            s.blockingPlay();
            s.write(path+filename);
        }

        /**
         * Plays the words in random order, each word can be played multiple times
         *
         * @param totalWords the total number of words that will be played
         * @param pause the number of milliseconds to pause between words
         * @throws InterruptedException
         */
        public void playRandomOrder(int totalWords, int pause) throws InterruptedException {
            //play the words in a random order by using a random num gen that goes through the numWords and play the total
            //number of the words wanted to be played and pause by the param
            Random random = new Random();
            for (int i = 0; i < totalWords; i++) {
                myWordArray[random.nextInt(numWords)].blockingPlay();
                Thread.sleep(pause);
        }
        }

        /**
         * Plays the words in random order, each word can be played multiple times
         * also writes sound to a file
         * @param totalWords the total number of words that will be played
         * @param pause the number of milliseconds to pause between words
         * @param filename take the filename to set 
         * @param path gets the path to save
         * @throws InterruptedException
         */
        public void playRandomOrder(int totalWords, int pause, String filename, String path) throws InterruptedException {
            //play the words in a random order by using a random num gen that goes through the numWords and play the total
            //number of the words wanted to be played and pause by the param
            int total = 0; //total samples
            int temp = (int)((pause/1000.0)*44100);
            //set random words to an array to help cal
            Random r= new Random();
            int[] ran= new int[totalWords];
            //get the total samples of the random words
            for (int i=0; i<totalWords; i++){
               ran[i]= r.nextInt(numWords);
            }
            for (int i =0; i<totalWords; i++ ){
                total = total+ myWordArray[ran[i]].getNumSamples();
                
            }
            total= total +(temp*(totalWords));
            Sound s = new Sound(total);
            
            int k = 0; //num sample your at
            int l = 0; // num word you are at
            for (int i =0; i<totalWords; i++){
                //set the words and pauses
                for(int j=0; j<myWordArray[ran[i]].getNumSamples();j++){
                    s.setSampleValueAt(k, myWordArray[ran[i]].getSampleValueAt(j));
                    k++;
                }
                if(l!=totalWords){
                    for(int w=0; w<temp; w++){
                    s.setSampleValueAt(k, 0);
                    k++;
                    }                 
                }
                l++;
            }
            s.blockingPlay();
            s.write(path+filename);
        }
        
        
            
        /**
         * Plays the words in random order, playing each word only once
         *
         * @param pause the number of milliseconds to pause between words
         * @throws InterruptedException
         */
        public void playRandomUnique(int pause) throws InterruptedException {
            Random random = new Random();
            int[] temp = new int[numWords];
            boolean a = false;
            //set the random numbers generated to an array
            for (int i = 0; i < numWords; i++) {
                temp[i] = random.nextInt(numWords);
                //if the numbers repeat the change
                for (int j = 0; j< i; j++){
                    if (temp[i] == temp[j]){
                    i--;
                    a=true;
                    break;
                    }
                }
                // if they are not the same then set the sound
                if(a==false){
                myWordArray[temp[i]].blockingPlay();
                Thread.sleep(pause);
                }

                else{
                    a=false;
                }
                }


                }
        
        
        
         /**
         * Plays the words in random order, playing each word only once
         * also writes sound to a file
         * @param pause the number of milliseconds to pause between words
         * @param filename take name to save the file
         * @param path takes the path to save the file to
         * @throws InterruptedException
         */
        public void playRandomUnique(int pause, String filename, String path) throws InterruptedException {
            int total = 0; // total samples
            int temp = (int)((pause/1000.0)*44100);
            Random r= new Random();
            int[] ran= new int[numWords];
            //set random numbers to a array to help cal
            for (int i = 0; i < numWords; i++) {
                ran[i] = r.nextInt(numWords);
                // if they are the same change the words
                for (int j = 0; j< i; j++){
                    if (ran[i] == ran[j]){
                    i--;
                    break;
                    }
                }
                }
            //get total samples   
            for (int i =0; i<numWords; i++ ){
                total = total+ myWordArray[ran[i]].getNumSamples();
                
            }
            total= total +(temp*(numWords));
            Sound s = new Sound(total);
            
            int k = 0; //sample your at
            int l = 0; // word your at
            for (int i =0; i<numWords; i++){
                //sets the words and pauses
                for(int j=0; j<myWordArray[ran[i]].getNumSamples();j++){
                    s.setSampleValueAt(k, myWordArray[ran[i]].getSampleValueAt(j));
                    k++;
                }
                if(l!=numWords){
                    for(int w=0; w<temp; w++){
                    s.setSampleValueAt(k, 0);
                    k++;
                    }                 
                }
                l++;
            }
            s.blockingPlay();
            s.write(path+filename);
        }

                





        /**
         * Plays the sound words in reverse order (e.g. 'this is a test' will be
         * played 'test a is this')
         *
         * @param pause the number of milliseconds to pause between words
         * @throws InterruptedException
         */
        public void playReverseOrder(int pause) throws InterruptedException {
            // play the words in reverse and use the pause param in sleep
            for (int i = numWords-1; i >= 0; i--) {
                myWordArray[i].blockingPlay();
                Thread.sleep(pause);
            }
        }
        
         /**
         * Plays the sound words in reverse order (e.g. 'this is a test' will be
         * played 'test a is this')
         * also writes sound to a file
         * @param pause the number of milliseconds to pause between words
         * @param filename take the filename to save as
         * @param path takes the path to save the file
         * @throws InterruptedException
         */
        public void playReverseOrder(int pause, String filename, String path) throws InterruptedException {
            int total = 0; // total samples
            int temp = (int)((pause/1000.0)*44100);
            //get the total samples
            for (int i =0; i<numWords; i++ ){
                total = total+ myWordArray[i].getNumSamples();
            }
            total= total +(temp*(numWords));
            Sound s = new Sound(total);
            
            int k = 0; //sample your at
            int l = 0; // word your at
            for (int i =numWords-1; i>=0; i--){
                //sets the words and the pauses
                for(int j=0; j<myWordArray[i].getNumSamples();j++){
                    s.setSampleValueAt(k, myWordArray[i].getSampleValueAt(j));
                    k++;
                }
                if(l!=numWords){
                    for(int w=0; w<temp; w++){
                    s.setSampleValueAt(k, 0);
                    k++;
                    }                 
                }
                l++;
            }
            s.blockingPlay();
            s.write(path+filename);
        }
        


        /**
         * Plays random pairs of consecutive words with only a 100 millisecond pause
         * between them, with a four hundred millisecond pause between pairs Ex: for
         * 'this is a test' a pair would only be 'this is' or 'is a' or 'a test'
         *
         * @param numDoublets the number of doublets to play
         * @throws InterruptedException
         */
        public void playDoublets(int numDoublets) throws InterruptedException {
            Random random = new Random();
            int j=0; // the doublets 
            // make sure to get the first word and the second without going out of bounds
            for (int i = 0; i < numDoublets; i++) {
                j= random.nextInt(numWords);
                if(j == numWords-1){
                    i--;
                }
                else{
                    myWordArray[j].blockingPlay();
                    Thread.sleep(100);
                    myWordArray[j+1].blockingPlay();
                    Thread.sleep(400);
                }

        }
        }
        
        /**
         * Plays random pairs of consecutive words with only a 100 millisecond pause
         * between them, with a four hundred millisecond pause between pairs Ex: for
         * 'this is a test' a pair would only be 'this is' or 'is a' or 'a test'
         * also writes sound to a file
         * @param numDoublets the number of doublets to play
         * @param filename takes the name to save the file
         * @param path takes the path to save the file
         * @throws InterruptedException
         */
        public void playDoublets(int numDoublets,String filename, String path) throws InterruptedException {
            int total = 0;//total samples
            int temp = (int)((100/1000.0)*44100);//100 pause
            int temp2 =(int)((400/1000.0)*44100);//400pause
            Random r= new Random();
            int[] ran= new int[numDoublets];
            //get the random doublets
            for (int i=0; i<numDoublets; i++){
               ran[i]=r.nextInt(numWords);
            if(ran[i]==numWords-1){
                i--;
                }
               
            }
            //cal the total samples
            for (int i =0; i<numDoublets; i++ ){
                total = total+ myWordArray[ran[i]].getNumSamples();
                total = total+ myWordArray[ran[i]+1].getNumSamples();
                
            }
            total= total +(temp *numDoublets )+((temp2)*(numDoublets));
            Sound s = new Sound(total);
            
            int k = 0; //sample your at
            int l = 0; //doublet your at
            for (int i =0; i<numDoublets; i++){
                //sets the first word and pause
                for(int j=0; j<myWordArray[ran[i]].getNumSamples();j++){
                    s.setSampleValueAt(k, myWordArray[ran[i]].getSampleValueAt(j));
                    k++;
                }
                if(l!=numDoublets){
                    for(int w=0; w<temp; w++){
                    s.setSampleValueAt(k, 0);
                    k++;
                    }                 
                }
                //sets the second word and pause
                for(int j=0; j<myWordArray[ran[i]+1].getNumSamples();j++){
                    s.setSampleValueAt(k, myWordArray[ran[i]+1].getSampleValueAt(j));
                    k++;
                }
                if(l!=numDoublets){
                    for(int w=0; w<temp2; w++){
                    s.setSampleValueAt(k, 0);
                    k++;
                    }                 
                }
                l++;
            }
            s.blockingPlay();
            s.write(path+filename);
        }
        
    /**
     * Plays random pairs of reverse consecutive words with only a 100 millisecond pause
     * between them, with a four hundred millisecond pause between pairs
     * plays doublets in reverse and plays the for the set number of doublets passed in
     * @param numDoublets get the number of doublets to play
     * @throws InterruptedException
     */
    public void playDoubletsReverse(int numDoublets) throws InterruptedException {
            Random random = new Random();
            int j=0;
            //gets the doublets in reverse and random order and sets condition to stay inbounds
            for (int i = 0; i < numDoublets; i++) {
                j= random.nextInt(numWords);
                if(j == 0){
                    i--;
                }
                else{
                    myWordArray[j].blockingPlay();
                    Thread.sleep(100);
                    myWordArray[j-1].blockingPlay();
                    Thread.sleep(400);
                }

        }
        }
        
        /**
         * Plays random pairs of reverse consecutive words with only a 100 millisecond pause
         * between them, with a four hundred millisecond pause between pairs
         * plays doublets in reverse and plays the for the set number of doublets passed in
         * also saves the sound to a file
         * @param numDoublets the number of doublets to play
         * @param filename takes the name to save the file as
         * @param path takes the path to save the file
         * @throws InterruptedException
         */
        public void playDoubletsReverse(int numDoublets,String filename, String path) throws InterruptedException {
            int total = 0;//total samples
            int temp = (int)((100/1000.0)*44100);
            int temp2 =(int)((400/1000.0)*44100);
            Random r= new Random();
            int[] ran= new int[numDoublets];
            //gets the random doublets in reverse order
            for (int i=0; i<numDoublets; i++){
               ran[i]=r.nextInt(numWords);
            if(ran[i]==0){
                i--;
                }
               
            }
            //gets the total samples
            for (int i =0; i<numDoublets; i++ ){
                total = total+ myWordArray[ran[i]].getNumSamples();
                total = total+ myWordArray[ran[i]-1].getNumSamples();
                
            }
            total= total +(temp *numDoublets )+((temp2)*(numDoublets));
            Sound s = new Sound(total);
            
            int k = 0; //sample your at
            int l = 0; // doublet your at
            for (int i =0; i<numDoublets; i++){
                //sets the first word and pause
                for(int j=0; j<myWordArray[ran[i]].getNumSamples();j++){
                    s.setSampleValueAt(k, myWordArray[ran[i]].getSampleValueAt(j));
                    k++;
                }
                if(l!=numDoublets){
                    for(int w=0; w<temp; w++){
                    s.setSampleValueAt(k, 0);
                    k++;
                    }                 
                } //sets second word and pause
                for(int j=0; j<myWordArray[ran[i]-1].getNumSamples();j++){
                    s.setSampleValueAt(k, myWordArray[ran[i]-1].getSampleValueAt(j));
                    k++;
                }
                if(l!=numDoublets){
                    for(int w=0; w<temp2; w++){
                    s.setSampleValueAt(k, 0);
                    k++;
                    }                 
                }
                l++;
            }
            s.blockingPlay();
            s.write(path+filename);
        }
        



    }
