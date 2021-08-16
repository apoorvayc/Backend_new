package com.rkit.jpaproject.entities;

import java.util.ArrayList;
import java.util.Random;

public class Quotes {

    private int rating;
    private String quote;
    ArrayList<String> quoteList[]=new ArrayList[10];

    public Quotes()
    {
        for(int i=0;i<10;i++)
        {
            quoteList[i]=new ArrayList<>();
        }
        quoteList[0].add("The same boiling water that softens the potato hardens the egg. It’s what you’re made of. Not the circumstances.");
        quoteList[0].add("If we have the attitude that it’s going to be a great day it usually is.– Catherine Pulsifier");
        quoteList[0].add("You can either experience the pain of discipline or the pain of regret. The choice is yours");
        quoteList[1].add("Impossible is just an opinion.– Paulo Coelho");
        quoteList[1].add("Your passion is waiting for your courage to catch up.– Isabelle Lafleche");
        quoteList[1].add("Magic is believing in yourself. If you can make that happen, you can make anything happen.– Johann Wolfgang Von Goethe");
        quoteList[2].add("If something is important enough, even if the odds are stacked against you, you should still do it.– Elon Musk");
        quoteList[2].add("Hold the vision, trust the process.");
        quoteList[2].add("Don’t be afraid to give up the good to go for the great.– John D. Rockefeller");
        quoteList[3].add("People who wonder if the glass is half empty or full miss the point. The glass is refillable");
        quoteList[3].add("The secret of getting ahead is getting started – Mark Twain");
        quoteList[3].add("I’ve missed more than 9,000 shots in my career. I’ve lost almost 300 games. 26 times I’ve been trusted to take the game winning shot and missed. I’ve failed over and over and over again in my life and that is why I succeed.Michael Jordan");
        quoteList[4].add("Don’t limit yourself. Many people limit themselves to what they think they can do. You can go as far as your mind lets you. What you believe, remember, you can achieve.– Mary Kay Ash");
        quoteList[4].add("The best time to plant a tree was 20 years ago. The second best time is now.Chinese Proverb");
        quoteList[4].add("Only the paranoid survive– Andy Grove");
        quoteList[5].add("It’s hard to beat a person who never gives up.– Babe Ruth");
        quoteList[5].add("I wake up every morning and think to myself, ‘how far can I push this company in the next 24 hours. – Leah Busque");
        quoteList[5].add("If people are doubting how far you can go, go so far that you can’t hear them anymore.– Michele Ruiz");
        quoteList[6].add("We need to accept that we won’t always make the right decisions, that we’ll screw up royally sometimes – understanding that failure is not the opposite of success, it’s part of success.– Arianna Huffington");
        quoteList[6].add("Write it. Shoot it. Publish it. Crochet it, sauté it, whatever. MAKE.– Joss Whedon");
        quoteList[6].add("Some cause happiness wherever they go; others whenever they go-Oscar Wilde");
        quoteList[7].add("Thousands of candles can be lighted from a single candle, and the life of the candle will not be shortened. Happiness never decreases by being shared.– Buddha");
        quoteList[7].add("Don’t rely on someone else for your happiness and self-worth. Only you can be responsible for that. If you can’t love and respect yourself – no one else will be able to make that happen. Accept who you are – completely; the good and the bad – and make changes as YOU see fit – not because you think someone else wants you to be different. – Stacey Charter");
        quoteList[7].add("There is only one way to happiness and that is to cease worrying about things which are beyond the power of our will. – Epictetus");
        quoteList[8].add("For every minute you are angry you lose sixty seconds of happiness.-Ralph Waldo Emerson");
        quoteList[8].add("Happiness is when what you think, what you say, and what you do are in harmony.– Mahatma Gandhi");
        quoteList[8].add("Happiness in intelligent people is the rarest thing I know– Ernest Hemingway");
        quoteList[9].add("Happiness is not something readymade. It comes from your own actions.– 14th Dalai Lama");
        quoteList[9].add("People are just as happy as they make up their minds to be.– Abraham Lincoln");
        quoteList[9].add("A man’s as miserable as he thinks he is.— Seneca");
    }

    public String getQuotes(int r)
    {
        Random rand = new Random();
        int t = rand.nextInt(3);
        return quoteList[r].get(t);

    }
}