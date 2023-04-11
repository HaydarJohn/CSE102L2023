import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class Ex4_20220808052
{
    public static void main(String[] args) {

    }

}

class Computer
{
    public CPU cpu;
    public RAM ram;

public Computer(CPU cpu , RAM ram)
{
    this.cpu = cpu;
    this.ram = ram;
}

public void run()
{
    int sum = 0;
    for (int i = 0; i < ram.getCapacity(); i++)
    {
        int value = ram.getValue(i,i);
        if (value != -1)
        {
            sum += value;
        }
    }
    ram.setValue(0, 0, sum);
    cpu.compute(0, 0);
}



}

class Laptop extends Computer {
    private int milliAmp;
    private int battery;

    public Laptop(CPU cpu, RAM ram, int milliAmp) {
        super(cpu, ram);
        this.milliAmp = milliAmp;
        this.battery = milliAmp * 30 / 100;
    }

    public int batteryPercentage() {
        return battery * 100 / milliAmp;
    }

    public void charge() {
        while (battery < milliAmp * 90 / 100) {
            battery += milliAmp * 2 / 100;
        }
        battery = milliAmp * 90 / 100;
    }

    @Override
    public void run()
    {
        if (battery > milliAmp * 5 / 100)
        {
            super.run();
            battery -= milliAmp * 3 / 100;
        }
        else
        {
            charge();
        }
    }

    @Override
    public String toString()
    {
        return super.toString() + " " + battery;
    }

}





class Desktop extends Computer {

    private ArrayList<String> peripherals;

    public Desktop(CPU cpu, RAM ram, String... peripherals)
    {
        super(cpu, ram);
        this.peripherals = new ArrayList<String>(Arrays.asList(peripherals));
    }

    @Override
    public void run()
    {
        int sum = cpu.compute(ram.getValue(0, 0), ram.getValue(0, 1));
        ram.setValue(0, 0, sum);
    }

    public void plugIn(String peripheral)
    {
        peripherals.add(peripheral);
    }

    public String plugOut()
    {
        if (peripherals.isEmpty())
        {
            return null;
        }
        return peripherals.remove(peripherals.size() - 1);
    }

    public String plugOut(int index) {
        if (index < 0 || index >= peripherals.size())
        {
            return null;
        }
        return peripherals.remove(index);
    }

    @Override
    public String toString()
    {
        return super.toString() + " " + String.join(" ", peripherals);
    }
}

class CPU
{
    private String name;
    private double clock;

    CPU(String name , double clock)
    {
        this.name = name;
        this.clock = clock;
    }
    public double getClock() {
        return clock;
    }
    public String getName() {
        return name;
    }
    public int compute(int a , int b)
    {
        return  a + b;
    }

    public String toString()
    {
        return "CPU: " + name + " " + clock + "Ghz";
    }

}

class RAM
{
    private String type;
    private int capacity;
    private int[][] memory;

    RAM(String type , int capacity)
    {
        this.type = type;
        this.capacity = capacity;
        intiMemory();
    }

    public int getCapacity() {
        return capacity;
    }
    public String getType() {
        return type;
    }

    private void intiMemory()
    {
        memory = new int[capacity][capacity];
        Random random = new Random();
        for(int i = 0; i < capacity; i++)
        {
            for(int j = 0 ; j < capacity; j++)
            {
                memory[i][j] = random.nextInt(11);
            }
        }
    }
    private boolean check(int i , int j)
    {
        if(i > capacity-1 || j > capacity - 1 )
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public int getValue(int i , int j)
    {
        if(check(i, j)) 
        {
            return memory[i][j];
        }
        else
        {
            return -1;
        }
    }

    public void setValue(int i, int j , int value)
    {
        if(check(i, j))
        {
            memory[i][j] = value;
        }
    }

    public String toString()
    {
        return "RAM: " + type + " " + capacity + "GB";
    }

}
