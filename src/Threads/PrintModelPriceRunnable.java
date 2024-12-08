package Threads;

public class PrintModelPriceRunnable implements Runnable{
    private TransportSynchronizer tSynch;
    public PrintModelPriceRunnable(TransportSynchronizer t){
        tSynch = t;
    }
    @Override
    public void run(){
        try{
            while(tSynch.canPrintPrice()){
                tSynch.printPrice();
            }
        }
        catch(Exception e){
            System.err.println(e.toString());
        }
    }
}
