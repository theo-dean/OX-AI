# OX-AI
An Artificial Intelligence agent that plays Naughts and Crosses.  
  
  
  
## Brief
The goal of this project is to create an Artificially Intellegent agent that is able to play the board game "naughts and crosses".  
To demonstrate the ability of the agent, a simple web application will be developed, allowing the user to play naughts and crosses with the agent.  
  
## Naughts and Crosses  
Naughts and Crosses (Tic-Tac-Toe) is simple game played on a 3x3 grid, by two players. One player plays as naughts; the other crosses. The players take it in turn to place a copy of their symbol in an empty grid position, the goal being to align three of the player's chosen symbol in a horizontal, vertical, or diagonal line. The game is won by a player, if they can align three of their symbol before the other player. Alternatively the game can be drawn if neither player aligns three of their symbol, and there is no possible sequence of moves that could result in either player winning.  

![Different game states for Naughts and Crosses](https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Tic-tac-toe-game-1.svg/1920px-Tic-tac-toe-game-1.svg.png)
###### Image Reproduced from en.wikipedia.org/wiki/Tic-tac-toe  


## Naughts and Crosses: Intelligence  
In order to play the game intelligently the player must consider their own move, but also the opposing player's following move, and future moves. This intelligence is intuitive to humans; often it is completely sub-concious. The goal of the agent is to be able to outsmart this human intelligence, and perform as well, if not better than a human. 

### Game Tree
A game of Naughts and Crosses can be represented as a tree. Each node in the tree represents a state of the game, with the children of a node representing possible next moves of that node. By constructing a tree in which each terminal node represents a terminal game state (win, lose, draw), and find a way to work out the value of each branch, we can then inform either a player, or an AI Agent.

![Game Tree](https://upload.wikimedia.org/wikipedia/commons/thumb/d/da/Tic-tac-toe-game-tree.svg/1920px-Tic-tac-toe-game-tree.svg.png)
###### Image Reproduced from en.wikipedia.org/wiki/Game_tree

### Minimax
Minimax is a decision rule used for minimizing the potential loss for a worst case scenario. Each terminal game state can be assigned a value correlating to its result for a given player. For example, from the naughts agent's perspective, a win for naughts could be assigned an arbitrary positive number, a win for the crosses player a negative number, and a draw as 0. By minimizing loss, the agent can try to prevent the player from winning, and improve it's own chances of winning at the same time.  

Pseudo-code for Minimax in this context is as follows...
```python
function minimax(node, maximisingPlayer){
    if node is terminal:
        return node.value
    if maximisingPlayer:
        value = -1
        for each child of node:
            value = max(value, minimax(child, FALSE)
        return value
     else: /* Minimising Player */
        value = 1
        for each child of node:
            value = min(value, minimax(child, TRUE)
        return value
```

## Implementation
### Frontend
The frontend is a web application using Angular, Bootstrap, and written in TypeScript, javascript, with HTML, and CSS.
The frontend provides a simple web application that allows the user to play Naughts and Crosses. The user can also play against the AI opponent.
When the user requests the opponent's move, the frontend app queuries the backend REST server, which returns the AI's best move, then played by the frontend.

### Backend
The backend uses Swing, and is written in Java.
The backend is essentially a REST service, that responds to solve requests from the front-end.
The backend returns the grid reference of the best move for the AI Agent.
            
