package miniTrabalho4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class Program {
	
	
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter full file path: ");
		
		String path = sc.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
		List<Employee> list = new ArrayList<>();
		
		String line = br.readLine();
		
		while (line != null) {
			
		String[] fields = line.split(",");
		
		list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
		
		line = br.readLine();
		}
		
		System.out.print("Enter salary: ");
		
		double salary = sc.nextDouble();
	//	-------
		
		//System.out.println("------------------------");
		
		//System.out.println("mostrar toda a lista:");
		
		//list.forEach(System.out::println); // mostra toda a lista
		
		//System.out.println("------------------------");
		
		//Nesta parte do programa complete o código em Programação funcional para mostrar a saída de programa solicitado.
		
		List <Employee> ordenado = list.stream()
					
		
						.filter(t->t.getSalary()>salary)// organiza uma lista apenas com os valores em que o salario > salary
						
						.collect(Collectors.toList());// cria a lista ordenado, com os parametros em cima
		
		//System.out.println("mostra a lista");
		//ordenado.forEach(System.out::println); // caso queiramos imprimrir a lista toda
		
		
		List<String> mailOrdenado = ordenado.stream()
		
				.map(t->t.getEmail()).sorted() // organiza uma lista apenas com os e-mails, de pessoas com salario > salary e organiza pro ordem alfabetica
				
				.collect(Collectors.toList());// cria a lista
		System.out.println("Email of people whose salary is more than: " + salary);
		mailOrdenado.forEach(System.out::println);// mostra a lista
		
		List<Employee> nomes = list.stream()
		
		.filter(t->t.getName().startsWith("M"))// organiza uma lista com pessoas cujo nome começam por M
		
		.collect(Collectors.toList());//cria a lista
		
		System.out.println("------------------------");
		
		//System.out.println("mostra a lista de funcionarios com nome começado por M e respectivo mail e ordenado:");
		//nomes.forEach(System.out::println);//imprime a lista
		
		
		Double soma = nomes.stream() 
				
				.map(t->t.getSalary())//cria uma variavel, a partir da lista de cima, apenas com os valores do salario
				
				.reduce(0.0, (x,y) -> x + y); //soma as variaveis e coloca-a numa variavel soma
		
		System.out.println("------------------------");
		
				System.out.println("Sum of salary of people whose name starts with 'M': " +soma);// imprime o resultado
		System.out.println("------------------------");			
		//-------
		} catch (IOException e) {
		System.out.println("Error: " + e.getMessage());
		}
		sc.close();
		}

}
