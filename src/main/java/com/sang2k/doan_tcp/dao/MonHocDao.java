/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sang2k.doan_tcp.dao;

import com.sang2k.doan_tcp.entity.DataSQL;
import com.sang2k.doan_tcp.entity.DatabaseLogin;
import com.sang2k.doan_tcp.entity.DiemThi;
import com.sang2k.doan_tcp.entity.MonHoc;
import com.sang2k.doan_tcp.entity.SinhVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Yahiko
 */
public class MonHocDao {
    public List<MonHoc> FindAllMH(DataSQL dt) throws Exception{
    String sql="SELECT * FROM [dbo].[MonHoc]";
     
      try (
            Connection con=DatabaseLogin.openConnection(dt);
            PreparedStatement dtb= con.prepareStatement(sql);
            )
        {
        try(ResultSet rs=dtb.executeQuery())
        {
            List<MonHoc> list =new ArrayList<MonHoc>();
            while (rs.next())
            {
                MonHoc sb=new MonHoc();
                sb.setMaMH(rs.getString("MaMH"));
                sb.setTenMH(rs.getString("TenMH"));
                list.add(sb); 
            }
            return list;
        }
        }     
    }   
    public MonHoc FindMH(String MaMH,DataSQL dt) throws Exception{
        String sql="SELECT * FROM [dbo].[MonHoc] WHERE [MaMH]=?";
            try (
            Connection con=DatabaseLogin.openConnection(dt);
            PreparedStatement dtb= con.prepareStatement(sql);
            )
            {
                dtb.setString(1,MaMH);
                try(ResultSet rs=dtb.executeQuery())
            {
                if (rs.next())
            {
                MonHoc sb=new MonHoc();
                sb.setMaMH(MaMH);
                sb.setTenMH(rs.getString("TenMH"));
                return sb;
            }    
            }
            }
        
        return null;
}
}
