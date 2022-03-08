package io.shibd.qbank.jd;

import java.util.concurrent.CompletableFuture;

/**
 * @author baozi
 */
public class Solution2 {

    public static void main(String[] args) {

        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            System.out.println("验证银行卡信息");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            throw new RuntimeException("银行卡信息验证失败");
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("验证黑名单信息");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("黑名单信息验证成功");
            return "黑名单信息验证成功";
        });

        CompletableFuture.anyOf(future1, future2).thenAccept(str -> {
            System.out.println("下单成功: " + str);
        }).exceptionally(e -> {
            System.out.println("下单失败: " + e.getMessage());
            return null;
        }).join();
    }
}
