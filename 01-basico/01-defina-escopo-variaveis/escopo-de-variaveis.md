# Escopo de variáveis

## Escopo local

variável local é declarada dentro de um **método** ou **construtor**, existindo dentro do bloco onde foi criada **{}**.

```java
public class Teste {
    public void m1() {
        // x existirá apenas neste bloco, sendo inacessível para qual quer outro escopo
        int x = 10;

        if (x >= 10) {
            // variável y só existirá dentro do bloco do if, sendo inacessível para qualquer outro bloco. Caso tentar acessar a variável
            // após o escopo do if, será lançado exception.
            int y = 50;
        }
    }
    public static void main(String args[]) {

    }
}
```

        Obs: cuidado com blocos implícito. As chaves podem não estarem visíveis mas existem.

Se voce definir o codeblock depois da declaração, a própria linha de declaração será o escopo implícito. Caso não definir na mesma linha,
mas sim na proxima, então o programa considerará a proxima linha como o escopo implícito.
```java
if () //codeblock, caso definir
// ou
if ()
//codeblock caso definir
```

## Escopo de variável de instancia/objeto

Variável de instancia é criada dentro da classe e pode ser referencia em qualquer método dentro do objeto e pela instancia do objeto, exceto
métodos statics, desde que haja um objeto instanciado.

```java
public class Teste {
    public String msg = "Hello World!";

    public void m1() {
        System.out.println(msg);
    }

        public Teste() {
        System.out.println(msg);
    }

        public static void m2() {
        System.out.println(msg);
    }
    public static void main(String[] args) {
        
    }
}
```

        conteúdos estáticos não podem acessar components não estáticos. 

## Escopo variáveis estáticas
Pode ser acessada através de instancia da class(existindo uma única para todas objetos criados a partir da class), classe, 
métodos(statics ou não), construtores.

        Variáveis estáticas podem ser acessadas de qualquer lugar na classe, desde que respeite os modificadores de acesso

## Cuidados a serem tomados nas declarações de variáveis

- Não pode existir vaiáveis locais com mesmo nome

```java
// não compila. Como o param é considerado uma var local, essa variável estará duplicada. Assim causando erro de compilação
public void m1 (String msg) {
    String msg = "Hello World!";
}
```

- Variáveis estáticas e de instância não podem ter o mesmo nome

```java
// Erro de compilação. Não pode existir variáveis estáticas e de instancia com mesmo nome! 
public class Teste {
    public static String msg;
    public  String msg;
}
```

- Variáveis locais podem ter o mesmo nome de varáveis de instância
```java
public class Teste {
    public String msg;

    public void m1(String msg) {
        this.msg = msg;
    }
}

```

Quando criamos uma variável de escopo com mesmo nome de uma variável de instancia, estaremos realizando o shadowing. pós não poderemos
usar a variável de instancia com uma chamada normal da referência, será necessário usar o **this** para se referenciar a variável de 
instância.

- Variáveis locais podem ter o mesmo nome de variáveis estáticas.

Bem semelhante ao shadowing da var de instância. Mas para acessar a var estáticas iremos utilizar a ClassName.

```java
public class Teste {
    public static String msg = "Hello World!";

    public void m1(String msg) {
        Teste.msg += " in Java language!";

    }


}
```