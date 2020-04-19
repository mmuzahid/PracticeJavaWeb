# PracticeJavaWeb
Practice Java Web Frameworks e.g. Spring, Hibernate etc

### Setup Environment and Run Application ###
- Install Java 1.8
- Install Tomcat 8.5
- Install MySQL 5
- Configure Database in daos.xml
- Install Maven 3
- Build Project
  i. Command line build example
		a. set JAVA_1_8_HOME environment variable
		b. run bellow maven command at project directory
		
			` mvn -Dmaven.compiler.fork=true -Dmaven.compiler.executable="%JAVA_1_8_HOME%\bin\javac" clean package `
	
  ii. Put following tags inside <configuration> of maven-compiler-plugin
	
				<fork>true</fork>
            <executable>${JAVA_1_8_HOME}\bin\javac</executable>
            <compilerVersion>${java.version}</compilerVersion>
            
- Deploy war in tomcat; either thru eclispe or something else - choice is yours!
- Visit http://localhost:8080/PracticeJavaWeb/