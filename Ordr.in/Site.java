import java.util.ArrayList;
import java.io.*;
public class Site {
	private ArrayList<ArrayList<BakeSale>> sales=new ArrayList<ArrayList<BakeSale>>();
	private ArrayList<String> ownernames=new ArrayList<String>();
	public void readOwners()
	{
		try
		{
			BufferedReader bf=new BufferedReader(new FileReader("owners.txt"));
			String line;
			while ((line=bf.readLine())!=null)
			{
				for (String s:ownernames)
				{
					if (!line.split(" ")[0].equals(s.split(" ")[0]))
					{
						ownernames.add(line);
						sales.add(new ArrayList<BakeSale>());
					}
				}
			}
			bf.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void writeOwners()
	{
		try
		{
			FileWriter fw=new FileWriter(new File("owners.txt"));
			for (String s:ownernames)
			{
				fw.write(s);
				fw.write("\n");
			}
			fw.flush();
			fw.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void addOwner(String name)
	{
		ownernames.add(name);
		sales.add(new ArrayList<BakeSale>());
		writeOwners();
	}
	public int passwordMatch(String username,String password)
	{
		for (String s:ownernames)
		{
			String[] temp=s.split(" ");
			if (temp[0].equals(username))
			{
				if (temp[1].equals(password))
					return 1;
				else
					return 0;
			}
		}
		return -1;
	}
	public void readSale(int owner,int subindex,String location)
	{
		if (subindex<=sales.get(owner).size());
		sales.get(owner).add(new BakeSale(owner,subindex,location,ownernames.get(owner).split(" ")[0]));
	}
	public void removeSale(int index)
	{
		sales.remove(index);
	}
	public void addItem(int owner,int subindex,String item)
	{
		sales.get(owner).get(subindex).addMenuItem(item);
	}
	public void addItem(int owner,int subindex,FoodItem i)
	{
		addItem(owner,subindex,i.toString());
	}
	public void removeItem(int owner,int subindex,String item)
	{
		sales.get(owner).get(subindex).removeMenuItem(item);
	}
	public void addStaff(int owner,int subindex,String staff)
	{
		sales.get(owner).get(subindex).addStaffMember(staff);
	}
	public void removeStaff(int owner,int subindex,String staff)
	{
		sales.get(owner).get(subindex).removeStaffMember(staff);
	}
}
