import javax.swing.*;
import java.awt.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Created by Protap on 6/12/2019.
 */
public class BenchMark implements Runnable{
    public JFrame jFrame;
    public static boolean finish;
    public static JLabel tx1,tx2,tx3,Jhost,Jip,JopName,JopType,JopVersio,JproCore,JfreeMem,JmaxMem,Jmac;
    Thread thread;

    BenchMark(){
        jFrame = new JFrame("Benchmark of CPU");
        tx1 = new JLabel("***CPU Benchmarking***");
        tx2 = new JLabel();
        tx3 = new JLabel();
        Jhost = new JLabel();
        Jip = new JLabel();
        JopName = new JLabel();
        JopType = new JLabel();
        JopVersio = new JLabel();
        JproCore = new JLabel();
        JfreeMem = new JLabel();
        JmaxMem = new JLabel();
        Jmac = new JLabel();


        thread = new Thread(this);
        thread.start();
        tx1.setBounds(180,0,310,70);
        tx2.setBounds(100,220,300,50);
        tx3.setBounds(185,200,120,50);

        Jhost.setBounds(100,30,300,50);
        Jip.setBounds(100,50,300,50);
        JopName.setBounds(100,70,300,50);
        JopType.setBounds(100,90,300,50);
        JopVersio.setBounds(100,110,300,50);
        JproCore.setBounds(100,130,300,50);
        JfreeMem.setBounds(100,150,300,50);
        JmaxMem.setBounds(100,170,300,50);
        Jmac.setBounds(100,190,300,50);
        tx1.setForeground(Color.blue);
        tx2.setForeground(Color.red);
        tx3.setForeground(Color.red);
        jFrame.add(tx1);
        jFrame.add(tx2);
        jFrame.add(tx3);
        jFrame.add(Jhost);
        jFrame.add(Jip);
        jFrame.add(JopName);
        jFrame.add(JopType);
        jFrame.add(JopVersio);
        jFrame.add(JproCore);
        jFrame.add(JfreeMem);
        jFrame.add(JmaxMem);
        jFrame.add(Jmac);

        jFrame.setSize(500,350);
        jFrame.setLayout(null);
        jFrame.setVisible(true);
    }
    public static void func(){
        int i;
        int num;
        String  primeNumbers = "";

        for (i = 1; i <= 50000; i++)
        {
            int counter=0;
            for(num =i; num>=1; num--)
            {
                if(i%num==0)
                {
                    counter = counter + 1;
                }
            }
            if (counter ==2)
            {
                primeNumbers = primeNumbers + i + " ";
            }
        }
    }

    public static boolean calulation(){
        long time1 = System .currentTimeMillis();
        func();
        long time2 = System . currentTimeMillis();
        tx2.setText("Time need to execute the program:  " + ( time2 - time1 )+" ms");
        return true;
    }

    public static void main(String args[]){
        new BenchMark();
        InetAddress ip;
        try {

            ip = InetAddress.getLocalHost();

            Jhost.setText("Current Host:  " + ip.getHostName());


            Jip.setText("Current IP address:  " + ip.getHostAddress());

            String nameOS= System.getProperty("os.name");

            JopName.setText("Current Operating System:  "+ nameOS);

            String osType= System.getProperty("os.arch");

            JopType.setText("Current Operating system type:  "+ osType);

            String osVersion= System.getProperty("os.version");

            JopVersio.setText("Current Operating system version:  "+ osVersion);

            JproCore.setText("Available processors (cores):  " +
                    Runtime.getRuntime().availableProcessors());

            JfreeMem.setText("Free Memory (in bytes):  " +
                    Runtime.getRuntime().freeMemory());

            long maxMemory = Runtime.getRuntime().maxMemory();

            JmaxMem.setText("Maximum memory (in bytes):  " +
                    (maxMemory == Long.MAX_VALUE ? "no limit" : maxMemory));


            NetworkInterface network = NetworkInterface.getByInetAddress(ip);

            byte[] mac = network.getHardwareAddress();

            System.out.print("Current MAC address:  ");

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            System.out.println(sb.toString());

        } catch (UnknownHostException e) {

            e.printStackTrace();

        } catch (SocketException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        if(calulation()){
            finish = true;
        }
    }

    @Override
    public void run() {
        try {
            while (true){
                if(finish){
                    tx3.setText("");
                    break;
                }
                else{
                    tx3.setText("Evaluating.");
                    thread.sleep(100);
                    tx3.setText("Evaluating..");
                    thread.sleep(100);
                    tx3.setText("Evaluating...");
                    thread.sleep(100);
                    tx3.setText("Evaluating....");
                    thread.sleep(100);
                    tx3.setText("Evaluating.....");
                    thread.sleep(100);
                    tx3.setText("Evaluating......");
                    thread.sleep(100);
                    tx3.setText("Evaluating.......");
                    thread.sleep(100);
                    tx3.setText("Evaluating........");
                    thread.sleep(100);
                    tx3.setText("Evaluating.........");
                    thread.sleep(100);
                }
            }
        }
        catch (Exception e){

        }
    }
}
