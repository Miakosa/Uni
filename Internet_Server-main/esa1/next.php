<html lang="de">
	<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 
    	@author Dennis Glowacki
    	@author Nikola KurzaC
    -->
	<link rel="stylesheet" type="text/css" href="style.css">
	<title>Projektkontakt</title>
	</head>
		<!-- Aufgabenteil b) -->
			<!--
			    <header> 
			    <h1>Projektkontakt</h1> 
			    </header>
			    <nav>
			        <ul>
			        	<li><?php echo"<a href='index.php'>Main</a>"; ?></li>
						<li><?php echo"<a href='next.php'>Projektkontakt</a>"; ?></li>
			        </ul>
			    </nav>
			    <main>
			        <h1> Projektkontakt </h1>
			        <form action=''>
			            <label for="vname">Vorname
			            <input type="text" id="vname" name="vname">
			            </label>
			            <label for="nname">Nachname
			            <input type="text" id="nname" name="nname">
			            </label>
			            <label for="mail">E-mail
			            <input type="email" id="mail" name="mail">
			            </label>
			            <label for="tel">Telefonnummer
			            <input type="number" id="tel" name="tel">
			            </label>
			            <input type='submit' value='Submit'/>
			        </form>
			    </main>	    
			-->
		<!-- Aufgabenteil c) -->
			<!--
			    <header> 
			    <h1>Projektkontakt</h1> 
			    </header>
			    <nav>
			        <ul>
			        	<li><?php echo"<a href='index.php'>Main</a>"; ?></li>
						<li><?php echo"<a href='next.php'>Projektkontakt</a>"; ?></li>
			        </ul>
			    </nav>
			    <main>
			        <h1> Projektkontakt </h1>
			        <form action=''>
			        <?php
			           echo "<label for='vname'>Vorname
				            <input id='vname' type='text' name='vname' placeholder='Texteingabe'>
				            </label>";
			           echo "<label for='nname'>Nachname
				    		<input id='nname' type='text' name='nname' placeholder='Texteingabe'>
				            </label>";
			           echo "<label for='mail'>E-mail
				            <input id='mail' type='email' name='mail' placeholder='Eingabe einer E-Mailadresse'>
				            </label>";
			           echo "<label for='tel'>Telefonnummer
				            <input id='tel' type='tel' name='tel' placeholder='Eingabe v. Ortsvorwahl und Anschluss'>
				            </label>";
			        ?>
			            <input type='submit' value='Submit'/>
			        </form>
			    </main>	  
			-->
		<!-- Aufgabenteil d) -->
	<body>
		<header> <h1>Projektkontakt</h1> </header>
		<nav>
		 <ul>
			<li><?php echo"<a href='index.php'>Main</a>"; ?></li>
			<li><?php echo"<a href='next.php'>Projektkontakt</a>"; ?></li>
			<li><?php echo"<a href='next2.php'>Fill Data</a>"; ?></li>
		 </ul>
		</nav>
		<main>
			<form action = ''> 
			<?php
			// Get the selected index from the URL
			$selected_index = $_GET['personen'];

			// Load the contents of data.json into a string variable
			$json_string = file_get_contents('data.json');

			// Parse the JSON string into a PHP object
			$json_object = json_decode($json_string);

			// Get the value of "vname" from the parsed JSON object for the selected person
			$vname = $json_object->personen[$selected_index]->vorname;
			$nname = $json_object->personen[$selected_index]->nachname;
			$mail = $json_object->personen[$selected_index]->email;
			$tel = $json_object->personen[$selected_index]->telefonnummer;

			// Output the HTML code with the input field pre-filled with the value of "vname"
			//echo "<p><label>Vorname <input id='vname' type='text' placeholder='Texteingabe' required value='$vname' /></label></p>";
 			echo "<label for='vname'>Vorname
				  <input id='vname' type='text' name='vname' placeholder='Texteingabe' required value='$vname'>
				  </label>";
			echo "<label for='nname'>Nachname
				  <input id='nname' type='text' name='nname' placeholder='Texteingabe'required value='$nname'>
				  </label>";
			echo "<label for='mail'>E-mail
				  <input id='mail' type='email' name='mail' placeholder='Eingabe einer E-Mailadresse' required value='$mail'>
				  </label>";
			echo "<label for='tel'>Telefonnummer
				  <input id='tel' type='tel' name='tel' placeholder='Eingabe v. Ortsvorwahl und Anschluss'>
				  </label>";		
			?>			
			<input type='submit' value='Submit'/>
			</form>
		</main>
	</body>
</html>
