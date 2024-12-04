package assign01;

public class Marks 
{
   String name;
   double marks;
   
   public Marks(String name, double marks) {
	this.name = name;
	this.marks = marks;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public double getMarks() {
	return marks;
}

@Override
public String toString() {
	return "Marks [name=" + name + ", marks=" + marks + "]";
}

public void setMarks(float marks) {
	this.marks = marks;
}
}
