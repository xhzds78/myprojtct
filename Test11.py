#!/usr/bin/env python3
# -*- coding: utf-8 -*-



import yfinance as yf
import pandas as pd
import matplotlib.pyplot as plt

tickers = {
    "^TWII": "TWII",
    "^N225": "N225",
    "^KS11": "KS11",
    "^DJI": "DJI",
    "^FTSE": "FTSE",
    "^FCHI": "FCHI",
    "^GDAXI": "GDAXI"
}

df_all = pd.DataFrame()

for ticker, country in tickers.items():
    stock = yf.Ticker(ticker)
    hist = stock.history(period="5y")
    df = hist.reset_index()
    df['Date'] = df['Date'].dt.tz_convert(None)
    df.set_index('Date', inplace=True)
    df = df.resample('M').last()
    df.reset_index(inplace=True)
    df['Date'] = df['Date'].dt.strftime('%Y-%m-%d')
    df[country] = df['Close'].round(2)
    if df_all.empty:
        df_all = df  
    else:
        df_all = pd.merge(df_all, df, on='Date', how='outer')  
df_all['Date'] = pd.to_datetime(df_all['Date']) 
df_all.sort_values('Date', inplace=True)

plt.figure(figsize=(14, 16))

# 绘制台湾加权指数
plt.subplot(4, 2, 1)
plt.plot(df_all['Date'], df_all['TWII'])
plt.title('TWII Close Price Over Time')
plt.xlabel('Date')
plt.ylabel('Close Price')

# 绘制日经225指数
plt.subplot(4, 2, 2)
plt.plot(df_all['Date'], df_all['N225'])
plt.title('N225 Close Price Over Time')
plt.xlabel('Date')
plt.ylabel('Close Price')

# 绘制韩国综合指数
plt.subplot(4, 2, 3)
plt.plot(df_all['Date'], df_all['KS11'])
plt.title('KS11 Close Price Over Time')
plt.xlabel('Date')
plt.ylabel('Close Price')

# 绘制道琼斯工业平均指数
plt.subplot(4, 2, 4)
plt.plot(df_all['Date'], df_all['DJI'])
plt.title('DJI Close Price Over Time')
plt.xlabel('Date')
plt.ylabel('Close Price')

# 绘制富时100指数
plt.subplot(4, 2, 5)
plt.plot(df_all['Date'], df_all['FTSE'])
plt.title('FTSE Close Price Over Time')
plt.xlabel('Date')
plt.ylabel('Close Price')

# 绘制法国CAC 40指数
plt.subplot(4, 2, 6)
plt.plot(df_all['Date'], df_all['FCHI'])
plt.title('FCHI Close Price Over Time')
plt.xlabel('Date')
plt.ylabel('Close Price')

# 绘制德国DAX指数
plt.subplot(4, 2, 7)
plt.plot(df_all['Date'], df_all['GDAXI'])
plt.title('GDAXI Close Price Over Time')
plt.xlabel('Date')
plt.ylabel('Close Price')

plt.tight_layout()
plt.show()
































# import csv
# import requests
# # replace the "demo" apikey below with your own key from https://www.alphavantage.co/support/#api-key
# CSV_URL = 'https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY_EXTENDED&symbol=IBM&interval=15min&slice=year1month1&apikey=B6IOK1XN6JU3JBYM'
# with requests.Session() as s:
#     download = s.get(CSV_URL)
#     decoded_content = download.content.decode('utf-8')
#     cr = csv.reader(decoded_content.splitlines(), delimiter=',')
#     my_list = list(cr)
#     for row in my_list:
#         print(row)