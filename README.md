# Tema-Testes-Caixa-Branca

1. **Uso do Driver Correto**  
   Substituição do driver incorreto pelo correto:  
   `com.mysql.cj.jdbc.Driver`

2. **Substituição de `Statement` por `PreparedStatement`**  
   Uso de `PreparedStatement` para evitar vulnerabilidades como *SQL Injection*.  

3. **Retirada de Credenciais Sensíveis do Código**  
   Credenciais como usuário, senha e URL foram movidas para variáveis de ambiente, configuradas em um arquivo `.env`.

4. **Tratamento de Exceções Adicionado**  
   Adição de blocos `catch` com logs para depuração, permitindo identificar e corrigir problemas.  

5. **Uso de `try-with-resources`**  
   Implementação de `try-with-resources` para garantir o fechamento automático de conexões, evitando vazamentos de recursos.  

6. **Melhor Encapsulamento**  
   Encapsulamento do campo `nome` com métodos *getter*, respeitando os princípios da programação orientada a objetos. 