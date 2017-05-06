package classLoader;

import java.io.File;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

import constants.Constants;
import plates.Shape;

public class ClassLoader {
	
	private static ClassLoader instance;
	
	private ClassLoader() {
		
	}
	
	public static ClassLoader getInstance() {
		if (instance == null) {
			instance = new ClassLoader();
		}
		return instance;
	}
	
	public ArrayList<Class<?>> loadClasses() {
		File classesFolder = new File(Constants.getInstance().getFilePath());
		ArrayList<Class<?>> classesList = new ArrayList<Class<?>>();
		try {
			classesList = concreteLoader(classesFolder);
		} catch (MalformedURLException e) {
			classesList = defaulter();
		} catch (ClassNotFoundException e) {
			classesList = defaulter();
		}
		return classesList;
	}
	
	private ArrayList<Class<?>> concreteLoader(File classesFolder) throws MalformedURLException, ClassNotFoundException {
		ArrayList<Class<?>> classesList = new ArrayList<Class<?>>();
		File file  = new File(classesFolder.getParentFile().getAbsolutePath());
		java.lang.ClassLoader parentLoader = Shape.class.getClassLoader();
		URLClassLoader ucl = URLClassLoader.newInstance(new URL[]{file.toURI().toURL()}, parentLoader);
		for (File classes : classesFolder.listFiles()) {
			String name = classesFolder.getName() + "." + classes.getName();
			name = name.substring(0, name.length() - 6);
			Class<?> loadedClass = (Class<?>) ucl.loadClass(name);
			if (check(loadedClass)) {
				classesList.add(loadedClass);
			}
		}
		return classesList;
	}
	
	private boolean check(Class<?> loadedClass) {
		if (Modifier.isAbstract(loadedClass.getModifiers())
				|| Modifier.isInterface(loadedClass.getModifiers())) {
			return false;
		}
		return true;
	}
	
	private  ArrayList<Class<?>> defaulter() {
		File classesFolder = new File("bin/plates");
		ArrayList<Class<?>> classesList = new ArrayList<Class<?>>();
		try {
			classesList = concreteLoader(classesFolder);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return classesList;
	}
}
