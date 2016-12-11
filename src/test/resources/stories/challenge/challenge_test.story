
Scenario: Add a new challenge

Given a new challenge with title My new challenge and description Challenge description
When I add this challenge
Then the system should contain this challenge

Scenario: Add a new challenge and add several ideas to it

Given a new challenge with title Another new challenge and description New challenge description
When I add this challenge
And submit an idea with title New idea and description What if we would do things in a different way
Then challenge Another new challenge should contain the New idea