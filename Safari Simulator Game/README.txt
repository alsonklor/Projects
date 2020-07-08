Safari Simulator:

This game gives you 30 pokeballs. With these 30 pokeballs your goal is to catch as many pokemon as
possible. Beware though, as pokemon may run away if you do not catch them. Each pokemon has a catch
probability and a run probability so play smart.

Besides being able to throw pokeballs, you can also throw rocks. Throwing rocks make the pokemon
angry for a random amount of turns (1-5), and while angry pokemon have their catch probability doubled and
run probability set to min(255, 4*[pokemon’s speed])/256. It is only doubled up to 33% though.

You can also throw bait at pokemon. Throwing bait makes pokemon eat for a random amount of turns (1-5).
While eating, pokemon have their catch rate halved and their run probability set to int([pokemon’s speed]/2)/256.

To run the game:
Run the Pokemon.py file.