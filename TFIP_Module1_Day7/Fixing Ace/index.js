//creating a deck of blackjack cards
let numberDecks = 6

// number of rounds simulated 
let numberSimulations = 50000

// Setting up the deck
const SUITS = ["♦", "♣", "♥", "♠"]
const VALUES = ["A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"]
let deck  = []

// define player hand and dealer hand
let playerHand = []
let dealerHand = []

let blackjack = false
let isAlive = false
let cardsLeft = numberDecks * 52

let round = 1
let losses = 0
let wins  = 0
let draws = 0

function startSimulation() {
    for (let i = 0; i < numberSimulations; i++) {
        createDeck()
        shuffleDeck()
        renderGame()
    
        let totalRounds = wins + losses + draws
        let winPer = wins / totalRounds *100
        let lossesPer = losses / totalRounds *100
        let drawsPer = draws / totalRounds *100
    
        console.log("Win: " + winPer.toFixed(2) + "%")
        console.log("Loss: " + lossesPer.toFixed(2) + "%")
        console.log("Draw: " + drawsPer.toFixed(2) + "%")
        console.log("END OF SIM " + (i + 1))

    }
    console.log("GAME OVER")

}




// _______________________________________________________________________main game function_________________________________________________________________________

// deal cards while the number of cards left is more than 25% of the deck
function renderGame() {
    do {
        // setting is alive to true and blackjack to false
        isAlive = true
        dealerAlive = true
        blackjack = false

        let playerSum = 0
        let dealerSum = 0

        // console.log("ROUND: " + round)

        playerHand = []
        dealerHand = []
        dealCards()
        
        // console.log("player: "+playerHand + "   " + "dealer: "+dealerHand)
        playerSum = countHand(playerHand)
        dealerSum = countHand(dealerHand)
        

        // console.log(playerSum + "    " + dealerSum)


        // check for starting hand blackjack win loss draw
        if (playerSum === 21 || dealerSum === 21) {
        
            blackjack = true

            if (playerSum < dealerSum) {
                losses += 1
            } else if (playerSum === dealerSum) {
                draws += 1
            } else {
                wins += 1
            }

        }
        
        // player draws card if sum less than 12                                                        (STRATEGY HERE)
        if (playerSum <12 && isAlive && !blackjack) {
            do {
                playerHand.push(deck.pop())
                playerSum = countHand(playerHand)
                // console.log("player: "+playerHand + "   " + "dealer: "+dealerHand)
                // console.log(playerSum + "    " + dealerSum)
                
            } while (playerSum < 12)

            if (playerSum > 21) {
                isAlive = false
                losses += 1
            }
        }

        

        // dealer draws card if sum less than 17
        if (dealerSum <17 && isAlive && !blackjack) {
            do {
                dealerHand.push(deck.pop())
                dealerSum = countHand(dealerHand)
                // console.log("player: "+playerHand + "   " + "dealer: "+dealerHand)
                // console.log(playerSum + "    " + dealerSum)
                
            } while (dealerSum < 17)

            if (dealerSum > 21) {
                dealerAlive = false
                wins += 1
            }
        }

        if (isAlive && !blackjack && dealerAlive) {
            if (playerSum < dealerSum) {
                losses += 1
            } else if (playerSum === dealerSum) {
                draws += 1
            } else {
                wins += 1
            }
        }

        // record win loss draw
        // console.log("Wins: " + wins + "    " + "Losses: " + losses + "    " + "Draws: " + draws)

        round += 1
        cardsLeft = deck.length

    } while (cardsLeft > 0.25 * numberDecks * 52 )

}




//__________________________________________________________________________________FUNCTIONS_________________________________________________________________________________

// creating a deck of cards with certain size
function createDeck() {
    for (let i = 0; i < numberDecks; i++) {
        SUITS.forEach(suit => {
            VALUES.forEach(value => {
                // console.log(value + suit)
                deck.push(value + suit)
            })
        })
    }
    return deck
}

// function to shuffle deck
function shuffleDeck() {
    for (let i = 0; i < deck.length; i++) {
        let tempCard = deck[i]
        let randomIndex = Math.floor(Math.random()*deck.length)
        deck[i] = deck[randomIndex]
        deck[randomIndex] = tempCard
    }
    return deck
}

// function to deal cards
function dealCards() {
    for (i = 0; i < 2; i++) {
        playerHand.push(deck.pop())
        dealerHand.push(deck.pop())
    }
    isAlive = true
    cardsLeft = deck.length

    // console.log(isAlive)
    // console.log(blackjack)
    // console.log(deck)

}


// function to count hand
function countHand(hand) {

    // count player hand
    let sum = 0
    let numberAces = 0
    let cardInt = []
    handSize = hand.length

    // count number of aces on hand
    for (let i = 0; i < handSize; i ++) {
        if (hand[i].charAt(0) == "A") {
            numberAces += 1
        }
    }

    // convert hand array string to array integer
    for (let i = 0; i < handSize; i++) { 
        if (hand[i].charAt(0) == "J" || hand[i].charAt(0) == "Q" || hand[i].charAt(0) == "K" || hand[i].charAt(0) == "1") {
            cardInt[i] = 10
        } else if (hand[i].charAt(0) == "A") {
            cardInt[i] = 11
        } else {
            cardInt[i] = Number(hand[i].charAt(0))
        }
    }

    sum = cardInt.reduce((a,b) => a + b, 0)
    
    // correct for AA == 22
    if (handSize === 2 && numberAces > 1) {
        // console.log("+++++++++++++++++++++++++++++++++++++++DOUBLE ACES++++++++++++++++++++++++++++++++++++++++++")
    }

    // changing values of aces
    if (handSize > 1 && numberAces > 0 && sum > 21) {
        // console.log("___________________________________________ACE HERE___________________________________________")

        if (sum > 21) {
            let repAces = numberAces
            do {
                sum -= 10
                repAces -= 1
            } while (sum > 21 && repAces > 0)
        }

 
    }

    return sum
}


function countNewCard() {
    
}


// hit stand or blackjack

