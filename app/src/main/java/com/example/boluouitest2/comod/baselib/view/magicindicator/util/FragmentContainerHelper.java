package com.example.boluouitest2.comod.baselib.view.magicindicator.util;

import android.annotation.TargetApi;

import com.example.boluouitest2.comod.baselib.view.magicindicator.Adapter.PositionData;

import java.util.List;

@TargetApi(11)
public class FragmentContainerHelper {

    /* renamed from: a */
    public static PositionData m9009a(List<PositionData> list, int i) {
        PositionData aVar;
        if (i >= 0 && i <= list.size() - 1) {
            return list.get(i);
        }
        PositionData aVar2 = new PositionData();
        if (i < 0) {
            aVar = list.get(0);
        } else {
            i = (i - list.size()) + 1;
            aVar = list.get(list.size() - 1);
        }
        aVar2.f13256a = aVar.f13256a + (aVar.m8974b() * i);
        aVar2.f13257b = aVar.f13257b;
        aVar2.f13258c = aVar.f13258c + (aVar.m8974b() * i);
        aVar2.f13259d = aVar.f13259d;
        aVar2.f13260e = aVar.f13260e + (aVar.m8974b() * i);
        aVar2.f13261f = aVar.f13261f;
        aVar2.f13262g = aVar.f13262g + (i * aVar.m8974b());
        aVar2.f13263h = aVar.f13263h;
        return aVar2;
    }



}
