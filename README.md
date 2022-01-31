# Forest Fire Simulation
## Introduction
College project on discrete modeling using cellular automata and various image tranformations. 

## Step by step
* Adding the source image to the project.
<p align="center">
    <img src="./input/input_map.bmp">
</p>

* The terrain image from google maps is binarized to separate the non-flammable terrain from the rest by the specified key.
<p align="center">
    <img src="./output/binarized_map.bmp">
</p>

* For a more logical and realistic simulation, the image is dilated - removal of small, isolated objects, as well as smoothing out the contours of a binary image.
<p align="center">
    <img src="./output/dilated_map.bmp">
</p>

* Simulating a forest fire using cellular automata in a regular window application to create and refine probability coefficients.
<p align="center">
    <img src="./output/no_wind_no_map_gif_30ms.gif">
</p>

* Adding the wind functionality - creating and refining wind-effect matrices.
<p align="center">
    <img src="./output/wind_no_map_gif_30ms.gif">
</p>

* Joining all the steps together.

### The final result


## Sources and inspirations
* https://en.wikipedia.org/wiki/Cellular_automaton
* https://nhess.copernicus.org/preprints/nhess-2018-227/nhess-2018-227.pdf
* https://youtu.be/bUd4d8BDIzI
