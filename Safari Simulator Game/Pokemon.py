import tkinter as tk
import random


# Pokemon Class. Used to hold all the pokedex info of each Pokemon.
class Pokemon:
    def __init__(self, dex, species, catch_rate, speed):
        self.species = species
        self.dex = str(dex)
        self.catch_rate = str(catch_rate)
        self.speed = str(speed)

    def __str__(self):
        return self.species

# Class that sets up game.
class SafariSimulator(tk.Frame):
    def __init__(self, master=None):

        # Getting the pokemon data from the pokedex.csv file
        with open("pokedex.csv") as file:
            poke_data = file.readlines()

        # poke_Dex contains Pokemon objects made from the data from the pokedex.csv file.
        poke_Dex = []
        for i in range(1, 152):
            poke = poke_data[i].split(",")
            poke_Dex.append(Pokemon(poke[0], poke[1], poke[2], poke[3]))

        # Initialize instance variables that need to be tracked
        self.poke_Dex = poke_Dex    # Array of all Pokemon Objects
        self.catchProb = 0          # Catch probability of current pokemon
        self.balls_left = 30        # Amount of pokeballs left
        self.species = 0            # Species of the current pokemon
        self.caughtPokemon = []     # Array of pokemon that have been caught
        self.speed = 0              # Speed of current pokemon
        self.runProb = 0            # Probability that current pokemon runs away
        self.turns_angry = 0        # Amount of turns that the pokemon is angry after throwing a rock
        self.turns_eating = 0       # Amount of turns that the pokemon is eating after throwing bait
        self.catch_rate = 0         # The percentage that the pokemon is going to be caught.

        # These lines set window parameters and create widgets
        tk.Frame.__init__(self, master)
        master.minsize(width=275, height=400)
        master.maxsize(width=275, height=400)
        master.title("Safari Zone Simulator")
        self.pack()
        self.createWidgets()

        # Call nextPokemon() method here to initialize first random pokemon
        self.nextPokemon()

    def createWidgets(self):
        # Creating "throwButton", which allows user to throw pokeball
        self.throwButton = tk.Button(self)
        self.throwButton["text"] = "Throw Safari Ball (" + str(self.balls_left) + " left)"
        self.throwButton["command"] = self.throwBall
        self.throwButton.grid(row=0, column=0, sticky="w")

        # "Run Away" button, which allows user to run away from pokemon
        self.runButton = tk.Button(self)
        self.runButton["text"] = "Run Away"
        self.runButton["command"] = self.nextPokemon
        self.runButton.grid(row=1, column=0, ipadx=38, sticky="w")

        # "Throw Rock" button, which allows user to make the pokemon angry for a certain amount of turns.
        self.throwRockButton = tk.Button(self)
        self.throwRockButton["text"] = "Throw Rock"
        self.throwRockButton["command"] = self.throwRock
        self.throwRockButton.grid(row=0, column=1, sticky="e")

        # "Throw Bait" button, which allows user to make the pokemon eat for a certain amount of turns.
        self.throwBaitButton = tk.Button(self)
        self.throwBaitButton["text"] = "Throw Bait"
        self.throwBaitButton["command"] = self.throwBait
        self.throwBaitButton.grid(row=1, column=1, sticky="e", ipadx=3)

        # Initializes the message label that indicates a pokemon has appeared.
        self.messageLabel = tk.Label(bg="grey")
        self.messageLabel.pack(fill="x", padx=5, pady=5)

        # Initializes the pokemon image.
        self.pokemonImageLabel = tk.Label()
        self.pokemonImageLabel.pack()

        # Initializes the catch probability label.
        self.catchProbLabel = tk.Label(bg="grey")
        self.catchProbLabel.pack(fill="x", padx=5, pady=5)

        # Initializes the run probability label
        self.runProbLabel = tk.Label(text="test", bg="grey")
        self.runProbLabel.pack(fill="x", padx=5, pady=5)

        # Initializes the label that indicates if the previous pokemon has run away or not.
        self.ranLabel = tk.Label(text="No Pokemon has run away!", bg="grey")
        self.ranLabel.pack(fill="x", padx=5, pady=5)

    def nextPokemon(self):

        # This method:
        # Chooses a random pokemon
        # Gets the info for the appropriate pokemon
        # Ensures text in messageLabel, catchProbLabel, and runProbLabel matches the pokemon
        # Changes the pokemonImageLabel to show the right pokemon

        # Note: the PhotoImage object MUST be stored as an instance
        # variable for some object (you can just set it to self.photo).
        # Not doing this will, for weird memory reasons, cause the image
        # to not be displayed.

        # Initializes the turns angry and turns eating to 0
        self.turns_angry = 0
        self.turns_eating = 0

        # Selects the next pokemon randomly
        random_poke = random.randint(0, 150)        # Chooses a random number corresponding to a pokemon
        next_pokemon = self.poke_Dex[random_poke]   # next_pokemon is the actual Pokemon object.

        # Initializes the variables to match the pokemon
        self.catchProb = min((int(next_pokemon.catch_rate) + 1), 151) / 449.5
        self.species = next_pokemon.species
        self.speed = int(next_pokemon.speed)
        self.runProb = (2 * self.speed) / 256
        self.catch_rate = next_pokemon.catch_rate

        # Sets up the GUI to display the proper stats of the new pokemon
        self.messageLabel['text'] = "You encountered a wild " + str(next_pokemon.species) + "!"
        self.photo = tk.PhotoImage(file="sprites/" + str(next_pokemon.dex) + ".gif")
        self.pokemonImageLabel["image"] = self.photo
        self.catchProbLabel["text"] = "Your chance of catching it is " + str(int(self.catchProb * 100)) + "%!"
        self.runProbLabel["text"] = str(self.species) + " has a " + str(int(self.runProb * 100)) + "% chance of running away!"


    def throwRock(self):

        # This method:
        # Throws a rock at the pokemon, making it angry for a random amount of turns.
        # When a pokemon is angry, its catch probability is doubled. Max probability is 33%.
        # Run probability is set to min(255, 4 * self.speed) / 256

        # Chooses a random number of turns the pokemon will be angry
        rand_angry = random.randint(1, 5)
        self.turns_angry += rand_angry

        # Doubles catch probability and sets run probability
        if (self.catchProb * 2) <= (151 / 449.5):
            self.catchProb = self.catchProb * 2
            self.catchProbLabel["text"] = "Your chance of catching it is " + str(int(self.catchProb * 100)) + "%!"
        self.runProb = min(255, 4 * self.speed) / 256
        self.runProbLabel["text"] = str(self.species) + " has a " + str(int(self.runProb * 100)) + "% chance of running away!"

    def throwBait(self):

        # This method:
        # Throws bait at the pokemon, making it eat for a random amount of turns.
        # When a pokemon is eating, its catch probability is halved.
        # Run probability is set to int(self.speed / 2) / 256

        # Chooses a random number of turns that the pokemon will be eating.
        # Halves the catch probability
        rand_eating = random.randint(1, 5)
        self.turns_eating += rand_eating
        self.catchProb = self.catchProb / 2

        # Sets the run probability.
        self.runProb = int(self.speed / 2) / 256
        self.runProbLabel["text"] = str(self.species) + " has a " + str(int(self.runProb * 100)) + "% chance of running away!"
        self.catchProbLabel["text"] = "Your chance of catching it is " + str(int(self.catchProb * 100)) + "%!"

    def throwBall(self):

        # This method:
        # Decrements the number of balls remaining
        # Tries to catch the pokemon
        # Checks to see if endAdventure() should be called

        # To determine whether or not a pokemon is caught, a random
        # number between 0 and 1 is generated using random.random().
        # If this number is less than min((catchRate+1), 151) / 449.5, then it is caught.

        # A random number between 0 and 1 will be generated again. If the pokemon is
        # not caught, and this number is less than the run probability, then
        # the pokemon will run away.

        # Generates random numbers.
        rand_num_catch = random.random()
        rand_num_run = random.random()

        # If balls remain, check if pokemon is caught or gets away.
        if self.balls_left > 0:
            if rand_num_catch < min((int(self.catch_rate) + 1), 151) / 449.5:
                self.balls_left -= 1
                self.throwButton["text"] = "Throw Safari Ball (" + str(self.balls_left) + " left)"
                self.caughtPokemon.append(self.species)
                self.ranLabel["text"] = "You caught " + str(self.species) + "!"
                self.nextPokemon()
            else:
                self.balls_left -= 1
                if self.turns_angry > 0:
                    self.turns_angry -= 1
                if self.turns_eating > 0:
                    self.turns_eating -= 1
                self.throwButton["text"] = "Throw Safari Ball (" + str(self.balls_left) + " left)"
                self.messageLabel["text"] = "Aargh! It escaped!"
                if rand_num_run < self.runProb:
                    self.ranLabel["text"] = str(self.species) + " ran away!"
                    self.nextPokemon()

        # If out of balls, end the game.
        else:
            self.endAdventure()

    def listCaughtPoke(self):

        # This method:
        # Helper function that turns the list of caught pokemon into a string.

        join = "\n".join(self.caughtPokemon)
        return join

    def endAdventure(self):

        # This method:
        # Sets up the GUI to display the end of game.

        # If there are pokemon caught, lists pokemon.
        if len(self.caughtPokemon) > 0:
            count = 0
            for i in range(len(self.caughtPokemon)):
                count += 1

            # Removes all the labels, buttons, and images from the GUI.
            self.ranLabel.pack_forget()
            self.pokemonImageLabel.pack_forget()
            self.messageLabel.pack_forget()
            self.catchProbLabel.pack_forget()
            self.runProbLabel.pack_forget()
            self.throwButton.grid_forget()
            self.runButton.grid_forget()
            self.throwRockButton.grid_forget()
            self.throwBaitButton.grid_forget()

            # Sets up end labels on the GUI
            self.endmessageLabel = tk.Label(text="You're all out of balls, hope you had fun!", bg="grey")
            self.endmessageLabel.pack(fill="x", padx=5, pady=5)
            self.emptyLabel = tk.Label(self)
            self.emptyLabel.pack(pady=20)
            self.pokemonCaughtmessageLabel = tk.Label(
                text="You caught " + str(count) + " Pokemon:\n" + str(self.listCaughtPoke()), bg="grey")
            self.pokemonCaughtmessageLabel.pack(fill="x", padx=5, pady=5)

        # If no pokemon are caught, set up end screen accordingly.
        else:

            # Gets rid of the labels, buttons, and images.
            self.pokemonImageLabel.pack_forget()
            self.messageLabel.pack_forget()
            self.catchProbLabel.pack_forget()
            self.runProbLabel.pack_forget()
            self.throwButton.grid_forget()
            self.runButton.grid_forget()
            self.throwRockButton.grid_forget()
            self.throwBaitButton.grid_forget()

            # Sets up the end screen.
            self.endmessageLabel = tk.Label(text="You're all out of balls, hope you had fun!", bg="grey")
            self.endmessageLabel.pack(fill="x", padx=5, pady=5)
            self.finalmessageLabel = tk.Label(text="Oops, you caught 0 Pokemon.", bg="grey")
            self.finalmessageLabel.pack(fill="x", padx=5, pady=5)

# DO NOT MODIFY: These lines start app
app = SafariSimulator(tk.Tk())
app.mainloop()
