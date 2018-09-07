class Estudiante{

	//atributos
	String nombre;
	int dni;
	int edad;
	String ciudadNatal;
	float calificacion;

	//constructor
	public Estudiante(String nombre,int dni,int edad,String ciudadNatal,float calificacion){
		this.nombre=nombre;
		this.dni=dni;
		this.edad=edad;
		this.ciudadNatal=ciudadNatal;
		this.calificacion=calificacion;
	}

	//metodos get y set
	public String getNombre(){
		return this.nombre;
	}

	public void setNombre(String nombre){
		this.nombre=nombre;
	}


	public float getCalificacion(){
		return this.calificacion;
	}

	public void setCalificacion(float calificacion){
		this.calificacion=calificacion;
	}
}

class Curso{

	ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();

	public ArrayList<Estudiante> getEstudiante() {
        return estudiantes;
	}

	public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
	}


	//Metodos
	public void agregarEstudiante(unEstudiante){ 
    	estudiantes.add(unEstudiante);
    }
	
	public resetearNotas(){
		int i;
		for(i=0; i < estudiantes.size(); i++){
			estudiantes[i].setCalificacion(0);
		}
	}

	public estudiantesAprobados(){
		int j;
		for(j=0; j<estudiantes.size(); j++){
			if(estudiantes[j].calificacion > 4){
				println ("Nombre: "+estudiantes[j].nombre+" - DNI: "+estudiantes[j].dni+" - Edad: "+estudiantes[j].edad+
					" - Ciudad Natal: "+estudiantes[j].ciudadNatal+" - Calificacion: "+estudiantes[j].calificacion);
			}
		}
	}

	public existeEstudiante(unEstudiante){
		int k;
		for(k=0; k<estudiantes.size(); k++){
			if(unEstudiante.dni == estudiantes[k].dni){
				println "El alumno con DNI: "+unEstudiante.dni+" se encuentra inscripto en el curso"
				break;
			}
			else{
				println "El alumno con DNI: "+unEstudiante.dni+" NO se encuentra inscripto en el curso"
				break;
			}
		}
	}

	public existeEstudianteConNotaDiez(){
		println "Alumnos con nota igual a diez: "
		int k;
		for(k=0; k<estudiantes.size(); k++){
			if(estudiantes[k].calificacion==10){
				println ("Nombre: "+estudiantes[k].nombre+" - DNI: "+estudiantes[k].dni);
			}
		}
	}

	
	/*public estudiantes(){}
	
	public existeEstudianteLlamado(unNombre){}
	public porcentajeDeAprobados(){}
	public promedioDeCalificaciones(){}
	public estudiantesNoCatamarquenios(){}
	public calificacionMasFrecuentes(){}
	public ciudadesExceptoCatamarca(){}
	public frecuenciaDeEdades(){}
	public unDesastre(){}*/
}
 def curso = new Curso();

curso.agregarEstudiante(new Estudiante("facu",37654210,23,"icaño",9))
curso.agregarEstudiante(new Estudiante("fabri",39424149,24,"Nueva Coneta",10))

println (curso.estudiantes[0].getNombre());
println (curso.estudiantes[1].getNombre());

println (curso.estudiantes[0].getCalificacion());
println (curso.estudiantes[1].getCalificacion());

curso.estudiantesAprobados();

curso.existeEstudiante(new Estudiante("nuevo",37654210,22,"SFVC",8));

curso.existeEstudianteConNotaDiez();
