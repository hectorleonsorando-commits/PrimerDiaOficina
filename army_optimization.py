from pulp import LpMaximize, LpProblem, LpVariable, lpSum

# Create the linear programming problem
prob = LpProblem("Army_Optimization", LpMaximize)

# Define variables (non-negative integers)
x = LpVariable("Swordsmen", lowBound=0, cat='Integer')
y = LpVariable("Bowmen", lowBound=0, cat='Integer')
z = LpVariable("Horsemen", lowBound=0, cat='Integer')

# Objective function: Maximize power
prob += 70*x + 95*y + 230*z, "Total_Power"

# Constraints
prob += 60*x + 80*y + 140*z <= 1200, "Food_Constraint"
prob += 20*x + 10*y <= 800, "Wood_Constraint"
prob += 40*y + 100*z <= 600, "Gold_Constraint"

# Solve the problem
prob.solve()

# Print the results
print("Status:", prob.status)
print("Optimal number of Swordsmen:", x.varValue)
print("Optimal number of Bowmen:", y.varValue)
print("Optimal number of Horsemen:", z.varValue)
print("Maximum Power:", prob.objective.value())