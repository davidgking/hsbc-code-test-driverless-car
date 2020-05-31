@Pilot
Feature: Driverless pilot
  Scenario Outline: Pilot1
    Given Build a rectangular car park min X:<MinPositionX> min Y:<MinPositionY>, max X:<MaxPositionX> max Y:<MaxPositionY> and driver a car in it X:<CarPositionX> Y:<CarPositionY>, orientation:<CarOrientation>
    When Input the commands:<Commands>
    Then The car will be on X:<CarLastPositionX> Y:<CarLastPositionY>, orientation:<CarLastOrientation>

  Examples:
  | MinPositionX | MinPositionY | MaxPositionX | MaxPositionY | CarPositionX | CarPositionY | CarOrientation | Commands                              | CarLastPositionX | CarLastPositionY | CarLastOrientation |
  | -3           | 2            | 5            | 9            | 0            | 3            | NORTH          | C                                     | 0                | 3                | EAST               |
  | -3           | 2            | 5            | 9            | 0            | 3            | NORTH          | F                                     | 0                | 4                | NORTH              |
  | -3           | 2            | 5            | 9            | 0            | 3            | EAST           | F                                     | 1                | 3                | EAST               |
  | -3           | 2            | 5            | 9            | 0            | 3            | EAST           | C,F,C                                 | 0                | 3                | SOUTH              |
  | -3           | 2            | 5            | 9            | 0            | 3            | NORTH          | F,F                                   | 0                | 5                | NORTH              |
  | -3           | 2            | 5            | 9            | 0            | 3            | EAST           | F,C,C,C,F,C,F,C,F,C,C,C,F,C,C,C,F,F,F | 3                | 6                | NORTH              |
