package Threads;

public class PrintModelNameRunnable implements Runnable{
    private TransportSynchronizer tSynch;
    public PrintModelNameRunnable(TransportSynchronizer t){
        tSynch = t;
    }
    @Override
    public void run(){
        try{
            while (tSynch.canPrintModel()) {
                tSynch.printModel();
            }
        }
        catch(Exception e){
            System.err.println(e.toString());   
        }
    }
}
