package MyTransport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
// ⣿⣿⣿⣿⣿⡿⢟⡛⣟⠛⠛⠿⠿⣿⡛⠛⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠛⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
// ⣿⣿⣿⣿⣿⡅⠄⢄⠈⠽⢶⡀⠈⠄⢀⠄⠄⠄⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠄⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
// ⣿⠛⢻⣿⣿⡇⠄⠄⠄⠄⠄⢤⡤⠈⠓⢺⡆⢢⠄⢙⣿⣿⣿⣿⣿⣿⣿⡇⠄⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
// ⣿⣶⣤⣈⡙⠃⠄⠄⠄⠄⠄⠄⠈⠁⠄⠠⠤⢬⣴⡀⠁⠻⣿⣿⣿⣿⣿⡇⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠋⠉⠁⡀⣻⣿⣿⣿⣿⣿⣿⣿⣿
// ⣿⣿⣿⣿⣿⡄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠿⣿⠿⣤⡀⠸⢿⣿⣿⣿⡇⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣿⣽⣿⣿⣿⡿⠿⠛⠄⠄⠄⠄⠄⠠⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿
// ⣿⣿⣿⣿⣿⣧⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⠓⢿⢿⣴⠁⠄⠄⠙⠛⣿⡇⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢯⣿⣿⣻⣭⣿⣿⣿⡟⠛⠁⠄⠄⠄⠄⠄⠄⠄⠑⢺⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
// ⣿⣿⣿⣿⣿⣿⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⠙⠄⠄⠄⠄⠄⠈⠄⠁⠿⡿⣯⡿⡿⠿⣿⣿⣿⣿⣿⣿⣿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾⣿⢯⣾⣿⠿⠛⢋⡀⠄⠤⠄⠄⠄⠄⠄⠄⠠⠴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
// ⣿⣿⣿⣿⣿⣿⣇⡀⠄⠄⠄⢄⡀⡂⢀⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⠃⠄⠁⠁⠄⢛⠿⢻⣿⣿⠿⢡⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢿⡿⣿⡿⣿⣿⣿⣏⣱⡿⠉⠾⠛⠉⢀⣤⡶⢊⠈⠄⠄⠄⢀⠄⢀⣠⣤⣤⣿⣿⣿⣿⣿⣿⣿⣿⣟⣛⣿
// ⣿⣿⣿⣿⣿⣿⣿⡇⠄⠄⠄⠄⠄⠸⢍⣽⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠠⠄⠄⠄⠄⠄⠆⢸⠇⠺⠄⠂⡟⠇⠈⢿⣿⣾⠿⠏⠄⢈⠈⠻⠏⠉⠽⠻⣿⠿⣿⠋⠉⠉⠄⠈⠁⠉⠨⠱⠰⠏⠈⠉⠄⠄⠄⢼⠷⠾⣾⡧⠁⠄⠄⣀⠄⠄⠄⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
// ⣿⣿⣿⣿⣿⣿⣿⣿⡀⠄⢀⡀⢀⣠⣀⣘⢧⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠸⣨⣸⣇⠉⠄⠄⣰⡇⠄⠄⠈⢖⣮⠉⠁⠘⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠁⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢠⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
// ⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣶⣷⣾⣿⣾⣗⠲⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠙⠘⠄⢀⣼⣿⠁⣤⣤⠄⠄⠋⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
// ⣿⣿⣻⢿⣿⣿⣿⣿⣟⣛⣿⣿⣿⣿⠯⡗⠄⠄⠂⠄⠄⠄⡀⣀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠑⠠⣀⣤⢻⣽⢆⡌⡟⠃⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢤⠿⣿⣿⣛⣛⣛⣛⣉⣀⣀⣠⣤⣤⣤⣄⣀⣸
// ⣿⣿⣿⣿⣶⣿⣿⣿⣿⣿⡟⠃⠈⠉⠄⠄⠄⠄⠄⠄⠄⠄⠄⠉⠐⠲⠔⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⠄⠐⠂⠉⢢⣿⣿⠆⠂⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⠄⠊⠄⠄⠄⠄⠠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
// ⣿⣿⣿⣭⣥⣀⣀⣈⣉⣉⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠐⠠⢉⢹⠄⠄⠈⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣀⣀⣐⣴⣦⣄⣤⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
// ⣿⣿⣿⣿⣿⣿⡟⡟⠁⠉⠛⠿⠿⢦⣤⣄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⡀⣀⡀⠄⠄⠄⠄⠙⡿⡿⣿⣿⣿⠿⣟⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
// ⣿⣿⣿⣿⣿⣿⣷⣿⣆⡀⠄⠄⠄⠄⠄⠄⡽⡿⠇⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠁⠄⠄⠄⠄⠄⠄⠿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
// ⣿⣿⣿⣿⣿⣿⣿⣿⡿⠶⠁⠄⠄⠄⠄⠄⠈⠂⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⠙⢛⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
// ⣿⣿⣿⣿⣿⣿⣿⣿⣇⣀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣀⣀⣀⣀⣀⣀⣈⣉⣉⣉⢛⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
// ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣰⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠠⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢀⣀⣀⣆⣀⢀⣂⣆⢀⡀⠄⠄⠜⡀⠄⠄⠄⠄⠄⠄⠄⠄⠑⠄⠄⠄⠄⠐⠰⠎⠉⠉⠁⠄⠈⠄⠄⣺⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
// ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢀⣴⠒⠠⠆⠄⠄⠄⠄⠄⠄⠄⠄⢢⣴⣿⣿⣿⠛⣿⣏⣴⣯⣁⣧⣼⣀⣤⡄⠄⠄⠄⣄⣤⣿⠄⠠⠋⠄⠄⠄⠄⠄⠉⠁⠄⠄⠄⠄⣠⣤⣶⣤⣿⣿⣿⣿⣿⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
// ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢿⣯⣥⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠠⠽⠿⠄⠄⠄⠄⠄⠄⡀⠄⠄⣠⣤⣈⣹⠿⢻⣿⠷⠛⠛⠻⠛⣿⣿⣿⣿⣿⣷⣀⠄⠄⠈⠙⠏⠄⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠙⢉⢛⣻⢿⣿⣿⣿⢿⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
// ⣿⣿⣿⣿⣿⣿⣿⣿⠿⣿⣿⣿⣿⣷⣄⣀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢀⡼⠛⣻⠼⢫⣤⣬⡥⡄⠨⠐⠄⠄⡘⣿⡿⠻⣿⣿⣿⣾⣤⠄⠄⠈⢼⢿⣀⢤⠄⠄⠄⠄⠄⠄⠄⠄⠄⠠⠄⢤⣥⣼⣿⣿⣿⣣⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
// ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡍⢙⣺⣿⣿⣟⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢀⣮⣥⣴⣿⠻⠄⠛⠚⠋⠄⠄⠄⠄⠄⠄⠄⢛⣻⡃⡷⢻⠇⠛⣟⠃⠄⠄⠄⠄⠈⠈⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⡄⣾⣽⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
// ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣫⣿⠦⠄⠄⠄⠄⣀⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣸⡅⠛⠉⠉⠄⠁⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠁⠇⢸⢽⣿⡟⠁⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣸⣿⣿⣿⣿⣿⣟⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
// ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢿⣿⢿⣧⣦⣤⣮⣤⡚⠃⠄⠄⣀⠄⠄⠄⠄⠄⠄⠄⣀⣘⠊⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣏⣸⠄⠄⠄⠄⠄⢀⡀⠄⠄⠄⠄⠄⠄⢀⣤⣊⣿⣿⣿⣧⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
// ⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠷⠾⠅⠽⠯⢿⣟⣬⣻⣗⣂⠤⠊⠁⠄⠄⠄⠄⠄⠄⠞⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠁⠿⠅⠁⠄⠄⢀⣸⣿⠇⠄⠄⠄⠄⠄⠸⡽⠼⢿⣿⣿⣿⣿⣿⣟⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
// ⣿⣿⣿⣿⣿⣯⣽⣿⣿⠿⠿⣶⣆⡀⠄⠄⢙⣙⡁⠉⣿⠉⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢠⠍⠨⠛⣉⣠⣤⣠⣤⣀⣤⣄⣭⣭⣻⣿⣿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
// ⣿⠛⠛⠛⠛⠻⠿⣻⣿⣶⣶⣛⣻⡇⠄⠤⠈⠶⣏⡁⣠⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⠈⠡⢶⣯⣿⣮⣭⣿⣿⣿⣿⣿⡟⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
// ⣿⠄⠄⣀⣀⠄⠄⠄⠄⠁⠉⠉⠉⠄⠄⠄⢀⣶⣿⣭⣏⣆⡀⠄⠄⠄⠄⠄⠄⠰⣀⠂⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣠⣿⣿⣿⣿⣿⣿⣿⣧⣒⣀⣀⣉⣉⣝⣙⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
// ⣿⣒⣶⣿⣿⣿⣿⣷⣷⣤⣽⣿⣥⣄⣶⣶⣿⠂⠄⡍⠁⠓⠄⠄⠄⠄⠄⠄⠄⠄⠈⠙⢳⣶⣦⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢠⣤⡖⠂⠄⠄⠄⠄⣿⣿⣿⣿⣿⣿⣿⣻⣿⣿⣿⣿⣿⡟⠻⢻⣿⣿⣿⣿⣿⣿⣿⡟⢿⣟⣛⡛⠛⠿⠿⣿⣿⣿⣿⣿⣿⣿
// ⣿⠒⠚⠛⠛⡿⣿⣿⣿⣿⣿⣿⣿⣿⣋⣉⣻⠒⢨⣷⣶⣾⣷⣍⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⠉⠻⠶⡄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣀⣠⣴⣶⠿⠛⠛⠁⠄⠄⠄⠄⣀⣻⣿⢻⣿⢛⣿⠙⠛⢹⣛⠄⢠⣀⡀⣀⣀⣀⣀⣀⣀⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢼
// ⣿⠦⠷⠄⠚⠃⠄⠘⠿⠿⣛⣓⡀⠃⠄⠄⠄⠁⠐⠛⠛⠋⠓⠛⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠘⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣠⠿⠛⠁⠄⠄⠄⠄⠄⠄⠄⢀⣰⢾⣿⣿⣿⣿⣿⣿⣯⣤⣼⣿⣿⣿⣿⣿⣿⡿⠻⠿⠿⠿⠿⠿⣿⣿⣿⣿⣿⣿⣿⣧⣤⣤⣤⣤⣤⣄⣀⣸
// ⣿⠄⠄⠄⠄⠈⡭⣠⣤⣤⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠁⠁⠄⠄⠄⠄⠄⠄⠄⠄⠐⠄⡤⣿⣿⣿⣿⣿⠿⢿⣿⣿⣿⣿⣿⣿⠛⠻⡇⠉⠉⠉⠄⠄⠒⠒⢠⣤⣤⣄⠉⠉⠉⠙⠛⠛⠛⣿⣿⣿⣿⣿⣿
// ⣿⣀⣀⣀⣀⢠⣿⣿⣿⣿⣿⣿⣶⡄⠄⠄⠄⠄⠠⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢀⡀⠉⠉⠙⠙⠛⠋⠄⠄⠘⠻⢿⣿⣻⠟⠢⠤⢄⡀⠄⠐⠒⠄⠤⢤⣀⣀⡀⠄⠈⠉⠙⠛⠒⠶⠶⢦⣤⣤⣬⣉⣹
// ⣿⠛⠛⠉⠁⠉⠛⠋⣻⣿⣿⠿⢿⣿⠦⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⠂⣀⠄⠠⣤⣤⡀⠄⠄⠠⣄⣈⣙⠛⠶⠦⠤⠈⠁⠄⠄⠄⠄⠄⠈⠉⠛⠛⠶⢶⣦⣤⣤⣀⣀⡀⠈⠉⠙⠛⠛⢻
// ⣿⠁⠄⣀⣠⠶⠏⠉⠁⠄⢀⣀⡼⠋⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠈⣿⣾⣿⣿⡿⢿⣿⣿⣿⣿⣿⣿⠉⠶⠄⠄⠄⢀⠄⠄⠉⠹⠿⢷⣶⣆⣀⠄⠄⠈⠉⠿⠿⢿⣿⣶⣶⣖⣀⣸
// ⣿⠄⠁⢀⣀⣤⣶⣶⠿⠟⠛⣻⣷⣄⡈⠁⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢀⣀⣀⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠛⠛⡛⠋⣛⣉⠙⠻⣧⣄⡈⠛⠳⢦⣄⡀⠄⠄⠄⠄⠄⠢⣤⣀⠄⠈⠉⠛⠻⢶⣶⣤⣄⣀⠈⠉⠙⠛⠿⢿
// ⣿⣀⣴⣾⣿⠿⠛⠋⣀⣤⣶⣿⡿⠟⠃⠄⡀⠄⣠⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢀⡀⠄⠄⠄⠄⠄⠩⢷⠆⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢀⣀⣴⣶⣧⣿⣯⣵⣶⣬⣉⡛⠷⣶⣤⡈⠉⠓⠦⢄⡀⠂⠤⣌⣉⠙⠷⢶⣤⣐⡐⠨⣉⣙⠻⠿⣶⣦⣤⣀⡀⢸
// ⣿⠿⠟⠃⢁⣀⣠⣼⣿⣿⠟⠂⢀⣀⠌⢃⣤⣷⣿⠸⠄⠄⠄⡀⠄⠄⠄⠄⠄⠄⠄⠄⢀⡾⠿⠄⠄⠄⢀⣀⡀⠄⠄⣅⣀⠄⠈⠄⠄⠄⠄⠄⠄⠄⢀⣀⣼⣿⣿⢿⣿⣿⣿⣿⠿⣿⣿⣿⣿⣿⣄⠄⠙⠻⣿⣤⡀⠄⠊⠄⢄⡀⠛⠉⣄⣀⠘⠛⠿⣧⣠⡘⠻⠧⣄⡛⠻⢿⣿⣿
// ⣿⠄⢤⣾⣾⣾⣿⣟⠁⠄⣴⣿⡟⣴⣾⣿⡟⠛⠁⠠⡀⠄⠄⠄⢄⣤⡂⢀⠄⠄⠄⢠⣌⠄⠠⣤⣀⠄⠘⠛⠁⠄⠄⠄⠙⣶⡆⠄⡄⢀⣀⡀⠄⣐⡆⠉⢹⣿⣿⡄⣮⣯⣽⣿⣷⢹⢿⣿⣿⣿⣿⣿⣦⠄⠄⠈⢩⣿⣶⣤⡀⠈⠐⢢⠈⠙⢳⣦⡶⣤⠉⠙⢳⣶⣬⠙⠛⢶⣭⣽
// ⣿⣶⣿⣿⣿⣿⡷⠇⡴⣛⣩⣽⣾⠿⢋⣁⣤⣶⠿⢻⣴⣶⡆⢽⡃⠄⠄⠄⠄⠄⠄⠈⠁⠄⠈⠛⠄⠄⢶⠄⣤⣠⢀⡠⠛⠛⠛⠙⠛⠋⠉⠓⠓⠻⢿⣧⣼⣃⣛⣷⡘⢻⣿⣿⣿⣇⡈⢿⣿⣿⣿⣿⣿⣷⣤⡀⠄⠠⣿⣿⣿⣶⣤⡀⠙⠓⢦⣙⠙⢿⣿⣷⣦⣌⡙⠳⠷⣬⣉⢻
// ⣿⣿⣿⣿⣿⣿⠠⢀⣼⣿⡿⠛⢃⣠⠿⠟⣃⣤⣼⣿⣿⣿⣿⠟⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠘⣿⣿⣿⣿⣿⡇⢺⣿⣿⣿⣿⣯⣿⣿⣿⣿⣿⣿⣿⣿⣿⣄⣀⠘⠿⣿⣿⣿⣿⣧⣄⡀⠛⠻⣤⣂⠻⣿⣿⣿⣧⣄⡘⠿⢿
// ⣿⣿⣿⡿⡿⢠⣾⣿⣏⠉⡀⠘⠉⣑⣾⣿⣿⣿⣿⣿⡿⠏⢀⢀⣰⣶⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠿⣿⣿⣿⣿⣿⡿⣿⣿⣿⣿⣿⢸⣿⣿⣿⣿⣿⣿⣿⡿⢶⣼⣷⡀⠈⢿⣿⣿⣿⣿⣿⣦⣀⠈⠯⣷⣆⡈⢿⣿⣿⣿⣷⣾
// ⣿⣿⠟⣣⣴⣿⣿⣿⣿⣿⣾⣿⣿⣿⣿⣿⣿⣿⣿⣁⣤⣾⠿⢟⣩⣴⡆⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣀⠄⢀⠄⠰⣶⣣⣾⣿⣿⣿⣧⡅⣿⣿⣿⣿⣿⠄⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡈⠙⠿⣿⣿⣿⣿⣿⣷⣤⡀⠙⠻⣷⣌⡙⠿⣿⣿
// ⣿⣻⣵⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⣛⣭⢴⣾⠟⠉⠁⠂⢀⠔⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣾⣧⣄⠄⠰⣿⣛⠿⣿⣿⣿⣿⣷⣿⣿⣿⣿⣿⣇⣿⣿⣿⣿⣿⣿⣿⡿⣿⣿⣯⣿⣿⣶⣤⡀⠻⢿⣿⣿⣿⣿⣿⣿⣦⣄⠉⠻⣷⣮⣉⢻
// ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣏⣉⣀⣾⣿⡏⠁⡁⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣶⣆⣸⣿⡄⠸⣿⣇⠾⡨⣿⣻⣷⣌⡹⣿⣿⣿⣿⣿⣿⣿⣿⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡆⠈⢿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠈⠹⣿⣿
// ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⣭⢀⠃⠁⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠛⢻⠿⡟⠄⠈⢻⠛⣶⡮⠛⣿⣿⣷⣷⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡄⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⠄⢹
// ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⣀⣮⢾⣞⠍⠄⠄⡀⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⢥⠢⢄⠈⣛⢿⣿⣶⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣟⣿⣿⣿⣿⣿⣿⣿⣄⡈⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣾
// ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⣿⢿⣽⣿⢢⠄⢸⠂⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⠄⣴⢸⣥⡌⣅⠛⣷⣜⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡌⠛⣿⣿⣿⣿⣿⣿⣿⣿⣿

import Exceptions.DuplicateModelNameException;
import Exceptions.ModelPriceOutOfBoundsException;
import Exceptions.NoSuchModelNameException;
import Vehicle.Vehicle;

public class QuadBike implements Vehicle {
    private String mark;
    private ArrayList<QuadBikeModel> models;
    public QuadBike(String name, int count){
        mark = name;
        models = new ArrayList<QuadBikeModel>();
        Random rnd = new Random();
        for(int i = 0; i < count; i++){
            models.add(new QuadBikeModel("Name: " + i, 1000 + (1000000 - 1000) * rnd.nextDouble()));
        }
    }

    public QuadBike(String name, String[] mod, double[] pr){
        mark = name;
        models = new ArrayList<QuadBikeModel>();
        for(int i = 0; i < mod.length; i++){
            models.add(new QuadBikeModel(mod[i], pr[i]));
        }
    }

    public double getPriceByName(String name) throws NoSuchModelNameException{
        for(QuadBikeModel tempModel : models){
            if(tempModel.getModelName().equals(name)){
                return tempModel.getPrice();
            }
        }
        throw new NoSuchModelNameException("ТАкого имени нет");
    }

    public void editModelName(String oldName, String newName) throws NoSuchModelNameException, DuplicateModelNameException{
        QuadBikeModel temp = null;
        for(QuadBikeModel tempModel : models){
            if(tempModel.getModelName().equals(newName)){
                throw new DuplicateModelNameException("Новое имя не уникально");
            }
            if(tempModel.getModelName().equals(oldName)){
                temp = tempModel;
            }
        }
        if(temp == null){
            throw new NoSuchModelNameException("Модель не найдена");
        }
        else{
            temp.setModelName(newName);
        }
    }

    public int getSize(){
        return models.size();
    }

    public void setPriceByName(String name, double newPrice) throws NoSuchModelNameException{
        if(newPrice < 0){
            throw new ModelPriceOutOfBoundsException("Неверная цена");
        }
        for(QuadBikeModel tempModel : models){
            if(tempModel.getModelName().equals(name)){
                tempModel.setPrice(newPrice);
                return;
            }
        }
        throw new NoSuchModelNameException("Модель не найдена");
    }

    public void deleteModelByName(String name) throws NoSuchModelNameException{
        for(QuadBikeModel tempModel : models){
            if(tempModel.getModelName().equals(name)){
                models.remove(tempModel);
                return;
            }
        }
        throw new NoSuchModelNameException("Модель не найдена");
    }

    public double[] getAllModelPrices(){
        double[] prices = new double[models.size()];
        for(int i = 0 ; i < models.size(); i++){
            prices[i] = models.get(i).getPrice();
        }
        return prices;
    }

    public String getMark(){
        return mark;
    }

    public void modelAdd(String name, double price)throws DuplicateModelNameException{
        if(price < 0){
            throw new ModelPriceOutOfBoundsException("Неверная цена");
        }
        for(QuadBikeModel tempModel : models){
            if(tempModel.getModelName().equals(name)){
                throw new DuplicateModelNameException("Новое имя не уникально");
            }
        }
        models.add(new QuadBikeModel(name, price));
    }

    public void setMark(String newMark){
        mark = newMark;
    }
    public String[] getAllModelNames(){
        String[] names = new String[models.size()];
        for(int i = 0; i < models.size(); i++){
            names[i] = models.get(i).getModelName();
        }
        return names;
    }

    private class QuadBikeModel implements Serializable{
        private String modelName;
        private double price;

        public QuadBikeModel(String name, double pr){
            modelName = name;
            price = pr;
        }

        public void setModelName(String value){
            modelName = value;
        }
        public String getModelName(){
            return modelName;
        }
        public void setPrice(double value){
            price = value;
        }
        public double getPrice(){
            return price;
        }
    }
}
