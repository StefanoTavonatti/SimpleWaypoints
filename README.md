# Simple Waypoints

A [Spigot](https://www.spigotmc.org/ "") plugin which allows the players to set waypoints in the server's world and to teleport to them immediately.


## In-game commands

- **/wsave \<waypoint name\>** saves a new waypoint (permission required: **simplewaypoints.waypoints**).
- **/wtp \<waypoint name\>** teleports to a waypoint (permission required: **simplewaypoints.waypoints**).
- **/wlist** shows the of list all waypoints (permission required: **simplewaypoints.waypoints**).
- **/wdelete \<waypoint name\>** delete a waypoint.

## Permissions:

- **simplewaypoints.waypoints**: Allow the user to use the personal waypoints.
 
### Basic "permissions.yml" for a small server.

This *permissions.yml* allows everyone to use the waypoints into the server.

```yaml
simplewaypoints.waypoints:
   description: Use the personal waypoints
   default: true
```

## Build the plugin

To build the plugin, type the following commands:

```bash
cd SimpleWaypoints
mvn clean package
```

or download an already compiled version: [https://github.com/StefanoTavonatti/SimpleWaypoints/releases](https://github.com/StefanoTavonatti/SimpleWaypoints/releases "")

## External links

- checkout the waypont plugin also in its Spigot page: [Simple Waypoints](https://www.spigotmc.org/resources/simple-waypoints.52934/ "")