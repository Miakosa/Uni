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
        	<form action="next.php" method="GET">
			  <label for="personen">Wähle ein Projektkontakt:</label>
			  <select id="personen" name="personen">
			    <option value="0">1</option>
			    <option value="1">2</option>
			    <option value="2">3</option>
			    <option value="3">4</option>
			    <option value="4">5</option>
			  </select>
			  <button type="submit">Kontakt laden</button>
			</form>
		</main>
	</body>
</html>


