class Empleado{
    float sueldoBasico(){
    return this.montoBasico() - this.aportes()
    }


    float montoBasico(){
    return 7000
    }

    float aportes(){
    return 100
    }

}

class EmpleadoJerarquico extends Empleado{
    
    
   float calcularSueldo(){
    return super.sueldoBasico() + this.bonoPorCategoria()
   }

   float montoBasico(){
    return 8000
   }

   float bonoPorCategoria(){
    return 2000
   }
   
}

class  Gerente extends EmpleadoJerarquico {
    
    
    float aportes(){
    return this.montoBasico() * 0.05
    }

    float montoBasico(){
    return 10000
    }
}  

def gerente = new Gerente()

println (gerente.aportes());  //ejercicio 1 a)

println (gerente.calcularSueldo()); //ejercicio 1 b)
