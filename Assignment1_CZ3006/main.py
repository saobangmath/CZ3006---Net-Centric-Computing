import matplotlib.pyplot as plt
import math

def Aloha(G):
    return G * math.exp(-2 * G)

def slottedAloha(G):
    return G * math.exp(-G)

def non_persistent(G, a):
    return G * math.exp(-a * G) / (G * (1 + 2 * a) + math.exp(-a * G))

def one_persistent(G, a):
    num = G * (1 + G + a * G * (1 + G + a * G / 2)) * math.exp(-G * (1 + 2 * a))
    det = G * (1 + 2 * a) - (1 - math.exp(-a * G)) + (1 + a * G) * math.exp(-G * (1 + a))
    return num / det

def p_persistent(G, p, a):
    num = (a + p) * G * math.exp(-(a + p) * G) - p * G * math.exp(-(2 * a + p) * G)
    det = (1 + a) * (1 - math.exp(-a * G)) + a * math.exp(-(a + p) * G)
    return num / det

# create the dataset x, set up p, a value and generate corresponding throughput
a = 0.01
p = 0.1
x = [i * 0.0001 for i in range(100000)]
aloha = [Aloha(i) for i in x]
slottedAloha = [slottedAloha(i) for i in x]
non_persistent = [non_persistent(i, a) for i in x]
one_persistent = [one_persistent(i, a) for i in x]
p_persistent = [p_persistent(i, p, a) for i in x]
# plotting
plt.plot(x, aloha, color = 'r', label = 'Pure Aloha')
plt.plot(x, slottedAloha, color = 'g', label = 'Slotted Aloha')
plt.plot(x, non_persistent, color = 'b', label = 'non_Persistent')
plt.plot(x, one_persistent, color = 'y', label = 'one_Persistent')
plt.plot(x, p_persistent, color ='purple', label = 'p_Persistent')
# figure setting
plt.xlabel("Load factor G")
plt.ylabel("Throughput S")
plt.title("Throughput analysis")
plt.legend()
plt.savefig("result.png")
plt.show()
