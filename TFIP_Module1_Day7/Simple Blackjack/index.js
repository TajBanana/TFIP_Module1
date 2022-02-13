//creating a deck of blackjack cards
let numberDecks = 1

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

createDeck()
shuffleDeck()

// deal cards while the number of cards left is more than 25% of the deck
do {
    // setting is alive to true and blackjack to false
    isAlive = true
    dealerAlive = true
    blackjack = false

    let playerSum = 0
    let dealerSum = 0

    console.log("ROUND: " + round)

    playerHand = []
    dealerHand = []
    dealCards()
    
    console.log("player: "+playerHand + "   " + "dealer: "+dealerHand)
    playerSum = countHand(playerHand)
    dealerSum = countHand(dealerHand)
    
    // correct for starting hand AA == 22
    if(playerSum > 21) {
        playerSum = 21
        // console.log("DOUBLE ACES")
    }

    if(dealerSum > 21) {
        dealerSum = 21
        // console.log("DOUBLE ACES")
    }

    console.log(playerSum + "    " + dealerSum)


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
    
    // player draws card if sum less than 12
    if (playerSum <12 && isAlive && !blackjack) {
        do {
            playerHand.push(deck.pop())
            playerSum = countHand(playerHand)
            console.log("player: "+playerHand + "   " + "dealer: "+dealerHand)
            console.log(playerSum + "    " + dealerSum)
            
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
            console.log("player: "+playerHand + "   " + "dealer: "+dealerHand)
            console.log(playerSum + "    " + dealerSum)
            
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
    console.log("Wins: " + wins + "    " + "Losses: " + losses + "    " + "Draws: " + draws)

    round += 1

} while (cardsLeft > 0.33 * numberDecks * 52 )

console.log("GAME OVER")






//__________________________________________________________________________________FUNCTIONS_________________________________________________________________________________

// creating a deck of cards with certain size
function createDeck() {
    for (let i = 0; i < numberDecks;i++) {
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
    handSize = hand.length

    for (let i = 0; i < handSize; i++) {
        if (hand[i].charAt(0) == "J" || hand[i].charAt(0) == "Q" || hand[i].charAt(0) == "K" || hand[i].charAt(0) == "1") {
            sum += 10
        } else if (hand[i].charAt(0) == "A") {
                sum += 11
        } else { 
            sum += Number(hand[i].charAt(0))
        }
    }
    return sum
}


function countNewCard() {
    
}